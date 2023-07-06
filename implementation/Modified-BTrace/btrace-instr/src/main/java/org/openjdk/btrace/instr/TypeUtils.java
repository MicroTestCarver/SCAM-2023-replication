/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the Classpath exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.openjdk.btrace.instr;

import static org.objectweb.asm.Opcodes.*;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.objectweb.asm.Type;
import org.openjdk.btrace.core.types.AnyType;

public final class TypeUtils {
  public static final Type objectArrayType = Type.getType(Object[].class);
  public static final Type anyTypeArray = Type.getType(AnyType[].class);
  private static final Map<String, String> primitives;

  static {
    primitives = new HashMap<>();
    primitives.put("void", "V");
    primitives.put("byte", "B");
    primitives.put("char", "C");
    primitives.put("double", "D");
    primitives.put("float", "F");
    primitives.put("int", "I");
    primitives.put("long", "J");
    primitives.put("short", "S");
    primitives.put("boolean", "Z");
  }

  private TypeUtils() {}

  public static boolean isPrimitive(String typeDesc) {
    if (typeDesc.length() == 1) {
      switch (typeDesc.charAt(0)) {
        case 'I':
        case 'J':
        case 'F':
        case 'D':
        case 'Z':
        case 'C':
        case 'B':
          {
            return true;
          }
      }
    }
    return false;
  }

  @SuppressWarnings("ReferenceEquality")
  public static boolean isPrimitive(Type t) {
    return t == Type.BOOLEAN_TYPE
        || t == Type.BYTE_TYPE
        || t == Type.CHAR_TYPE
        || t == Type.DOUBLE_TYPE
        || t == Type.FLOAT_TYPE
        || t == Type.INT_TYPE
        || t == Type.LONG_TYPE
        || t == Type.SHORT_TYPE;
  }

  public static boolean isAnyType(Type t) {
    return t.equals(Constants.ANYTYPE_TYPE);
  }

  public static boolean isAnyTypeArray(Type t) {
    return t.equals(anyTypeArray);
  }

  public static boolean isObject(Type t) {
    return t.equals(Constants.OBJECT_TYPE);
  }

  public static boolean isObjectOrAnyType(Type t) {
    return isObject(t) || isAnyType(t);
  }

  public static boolean isString(Type t) {
    return t.equals(Constants.STRING_TYPE);
  }

  public static boolean isArray(Type t) {
    return t.getSort() == Type.ARRAY;
  }

  public static boolean isThrowable(Type t) {
    return t.equals(Constants.THROWABLE_TYPE);
  }

  public static boolean isVoid(Type t) {
    return Type.VOID_TYPE.equals(t) || Constants.VOIDREF_TYPE.equals(t);
  }

  public static Type getArrayType(int arrayOpcode) {
    switch (arrayOpcode) {
      case IALOAD:
      case IASTORE:
        return Type.getType("[I");

      case BALOAD:
      case BASTORE:
        return Type.getType("[B");

      case AALOAD:
      case AASTORE:
        return objectArrayType;

      case CALOAD:
      case CASTORE:
        return Type.getType("[C");

      case FALOAD:
      case FASTORE:
        return Type.getType("[F");

      case SALOAD:
      case SASTORE:
        return Type.getType("[S");

      case LALOAD:
      case LASTORE:
        return Type.getType("[J");

      case DALOAD:
      case DASTORE:
        return Type.getType("[D");

      default:
        throw new RuntimeException("invalid array opcode");
    }
  }

  public static Type getElementType(int arrayOpcode) {
    switch (arrayOpcode) {
      case IALOAD:
      case IASTORE:
        return Type.INT_TYPE;

      case BALOAD:
      case BASTORE:
        return Type.BYTE_TYPE;

      case AALOAD:
      case AASTORE:
        return Constants.OBJECT_TYPE;

      case CALOAD:
      case CASTORE:
        return Type.CHAR_TYPE;

      case FALOAD:
      case FASTORE:
        return Type.FLOAT_TYPE;

      case SALOAD:
      case SASTORE:
        return Type.SHORT_TYPE;

      case LALOAD:
      case LASTORE:
        return Type.LONG_TYPE;

      case DALOAD:
      case DASTORE:
        return Type.DOUBLE_TYPE;

      default:
        throw new RuntimeException("invalid array opcode");
    }
  }

  public static String declarationToDescriptor(String decl) {
    int leftParen = decl.indexOf('(');
    int rightParen = decl.indexOf(')');
    if (leftParen == -1 || rightParen == -1) {
      throw new IllegalArgumentException();
    }

    StringBuilder buf = new StringBuilder();
    String descriptor;

    buf.append('(');
    String args = decl.substring(leftParen + 1, rightParen);
    StringTokenizer st = new StringTokenizer(args, ",");
    while (st.hasMoreTokens()) {
      String arg = st.nextToken().trim();
      descriptor = primitives.get(arg);
      if (arg.length() == 0) {
        throw new IllegalArgumentException();
      }
      if (descriptor == null) {
        descriptor = objectOrArrayType(arg);
      }
      buf.append(descriptor);
    }
    buf.append(')');

    String returnType = decl.substring(0, leftParen).trim();
    descriptor = primitives.get(returnType);
    if (returnType.length() == 0) {
      throw new IllegalArgumentException();
    }
    if (descriptor == null) {
      descriptor = objectOrArrayType(returnType);
    }
    buf.append(descriptor);
    return buf.toString();
  }

  public static String descriptorToSimplified(String desc, String owner, String name) {
    String retTypeDesc = null;
    Type[] args = null;
    if (desc.contains("(")) {
      retTypeDesc = Type.getReturnType(desc).getDescriptor();
      args = Type.getArgumentTypes(desc);
    } else {
      retTypeDesc = isPrimitive(desc) ? desc : Type.getType(desc).getDescriptor();
      args = new Type[0];
    }
    StringBuilder sb = new StringBuilder();
    sb.append(getJavaType(retTypeDesc))
        .append(' ')
        .append(owner.replace('/', '.'))
        .append('#')
        .append(name);
    if (args.length > 0) {
      sb.append("(");
      boolean more = false;
      for (Type t : args) {
        if (more) {
          sb.append(", ");
        } else {
          more = true;
        }
        sb.append(getJavaType(t.getDescriptor()));
      }
      sb.append(')');
    }
    return sb.toString();
  }

  public static String getJavaType(String desc) {
    int arrIndex = desc.lastIndexOf('[') + 1;
    desc = arrIndex > 0 ? desc.substring(arrIndex) : desc;
    if (desc.startsWith("L")) {
      desc = desc.substring(1, desc.length() - 1).replace('/', '.');
    } else {
      for (Map.Entry<String, String> entry : primitives.entrySet()) {
        if (entry.getValue().equals(desc)) {
          desc = entry.getKey();
          break;
        }
      }
    }
    StringBuilder sb = new StringBuilder(desc);
    for (int i = 0; i < arrIndex; i++) {
      sb.append("[]");
    }
    return sb.toString();
  }

  public static String objectOrArrayType(String type) {
    StringBuilder buf = new StringBuilder();
    int index = 0;
    while ((index = type.indexOf("[]", index) + 1) > 0) {
      buf.append('[');
    }
    String t = type.substring(0, type.length() - buf.length() * 2);
    String desc = primitives.get(t);
    if (desc != null) {
      buf.append(desc);
    } else {
      buf.append('L');
      if (t.indexOf('.') < 0) {
        buf.append(t);
      } else {
        buf.append(t.replace('.', '/'));
      }
      buf.append(';');
    }
    return buf.toString();
  }
}
