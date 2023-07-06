DIRECTORY_FOLDER=${1##*/}
echo "Directory Folder: $DIRECTORY_FOLDER"
btracec "$1/$2.java"
btracer "$DIRECTORY_FOLDER/$2.class" "$1/$3.java"