import streamlit as st
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.ticker as mtick

st.set_page_config(layout="wide")

#### Plot code for likert 100% stacked bar chart taken from: https://www.kaggle.com/code/dradamjones/100-stacked-bar-chart-from-likert-scale-data and adapted


plt.style.use('ggplot')
plt.subplots(3, 1, height_ratios=[5, 5, 5], figsize=(5, 10), dpi=(300))
plt.subplots_adjust(hspace=0.3)

def plot_likert_from_dict(plt, results, columns, plot_name, plot_index, ax1=None):

  data = pd.DataFrame.from_dict(results)
  data.columns = columns

  if ax1 is None:
    plt.subplot(3, 1, plot_index)
  else:
    plt.subplot(3, 1, plot_index, sharex=ax1)
  
  #read the data
  df = data[::-1] # flip order so in the later plot it will be top-bottom as in the data
  # df.columns

  #change the order so question with most agree is at the top
  #df = df.sort_values(by=['l_sa'])

  # df = df.sort_values(['Questoin'], ascending=False)

  #populate the variables from the csv
  questions = df["Question"]
  strongdisagree = df["Strongly disagree"]
  disagree = df["Disagree"]
  neutral = df["Neutral"]
  agree = df["Agree"]
  strongagree = df["Strongly agree"]

  ind = [x for x, _ in enumerate(questions)]

  #calculate the percentages for the 100% stacked bars
  total = strongdisagree+disagree+neutral+agree+strongagree
  proportion_strongdisagree = np.true_divide(strongdisagree, total) * 100
  proportion_disagree = np.true_divide(disagree, total) * 100
  proportion_neutral = np.true_divide(neutral, total) * 100
  proportion_agree = np.true_divide(agree, total) * 100
  proportion_strongagree = np.true_divide(strongagree, total) * 100

  plt.subplots_adjust(right=4, bottom=0.001)

  #plot the bars
  plt.barh(ind, proportion_strongagree, label='Strongly agree', color='#1b617b',  left=proportion_strongdisagree+proportion_disagree+proportion_neutral+proportion_agree)
  plt.barh(ind, proportion_agree, label='Agree', color='#879caf',   left=proportion_strongdisagree+proportion_disagree+proportion_neutral)
  plt.barh(ind, proportion_neutral, label='Neutral', color='#e7e7e7',   left=proportion_strongdisagree+proportion_disagree)
  plt.barh(ind, proportion_disagree, label='Disagree', color='#e28e8e',   left=proportion_strongdisagree)
  plt.barh(ind, proportion_strongdisagree, label='Strongly disagree', color='#c71d1d')

  # for i, v in enumerate(proportion_strongdisagree):
  #     plt.text(v/2, i, f'{v:.1f}%', color='white', va='center', ha='center', fontsize=25)
  # for i, v in enumerate(proportion_disagree):
  #     plt.text(v/2 + proportion_strongdisagree[i], i, f'{v:.1f}%', color='white', va='center', ha='center', fontsize=25)
  # for i, v in enumerate(proportion_neutral):
  #     plt.text(v/2 + proportion_strongdisagree[i] + proportion_disagree[i], i, f'{v:.1f}%', color='black', va='center', ha='center', fontsize=25)
  # for i, v in enumerate(proportion_agree):
  #     plt.text(v/2 + proportion_strongdisagree[i] + proportion_disagree[i] + proportion_neutral[i], i, f'{v:.1f}%', color='black', va='center', ha='center', fontsize=25)
  # for i, v in enumerate(proportion_strongagree):
  #     plt.text(v/2 + proportion_strongdisagree[i] + proportion_disagree[i] + proportion_neutral[i] + proportion_agree[i], i, f'{v:.1f}%', color='white', va='center', ha='center', fontsize=25)
  # set the axes
  plt.yticks(ind, questions)
  # plt.ylabel("Questions")
  # plt.xlabel("Responses")
  # plt.title("Survey Responses")
  plt.xlim=1.0
  plt.margins(x=0.01)

  #fine tune the labels
  ax=plt.gca()
  if plot_index == 3:
    plt.setp(ax.get_xticklabels(), rotation=45, horizontalalignment='right')
    ax.xaxis.set_major_formatter(mtick.PercentFormatter(xmax=100, symbol='%'))
    plt.xticks([0, 25, 50, 75, 100])
  else:
    for tick in ax.xaxis.get_major_ticks():
        tick.tick1line.set_visible(False)
        tick.tick2line.set_visible(False)
        tick.label1.set_visible(False)
        tick.label2.set_visible(False)
  ax.grid(color='black', linestyle='-', axis="x", linewidth=1)
  ax.set_facecolor('white')
  plt.tick_params(labelsize=25)
  plt.xticks(fontsize=25)

  ax.set_title(plot_name, fontsize=30, x=-0.15)

  if plot_index == 1:
    ## flip order of legend and display at top
    handles, labels = ax.get_legend_handles_labels()
    ax.legend(
        handles[::-1],
        labels[::-1],
        bbox_to_anchor=(0.47, 1.25),
        loc="lower center",
        borderaxespad=0,
        frameon=False,
        ncol=5,
        fontsize="25",
    )

  average = (strongdisagree * 1 + disagree * 2 + neutral * 3 + agree * 4 + strongagree * 5) / total

  # Create secondary y-axis with average
  ax2 = ax.twinx()
  ax2.set_ylim(ax.get_ylim())
  ax2.set_yticks(ind)
  ax2.set_yticklabels(round(average, 2))
  ax2.tick_params(labelsize=25)
  ax2.yaxis.set_tick_params(width=0)

  # Set label for secondary y-axis
  ax2.set_ylabel('Average', fontsize=15, labelpad=15)

  return ax
  # plt.savefig(f'{plot_name}.pdf', bbox_inches='tight')

  # st.pyplot(plt)

category_names = ['Strongly disagree', 'Disagree',
                  'Neutral', 'Agree', 'Strongly agree']
columns = ["Question","Strongly disagree","Disagree","Neutral","Agree","Strongly agree"]

results = [
    ['C1. The identifiers are descriptive', 0, 1, 4, 10, 15,],
    ['C2. The test data is descriptive', 1, 1, 4, 12, 12,],
    ['C3. The test makes sense in the domain', 0, 1, 5, 10, 14,],
    ['C4. The intent of the test is easy to understand', 0, 2, 2, 11, 15,],
]
ax1 = plot_likert_from_dict(plt, results, columns, "MTC", 1)


results = [
    ['C1. The identifiers are descriptive', 1, 5, 1, 13, 10,],
    ['C2. The test data is descriptive', 1, 4, 5, 6, 13,],
    ['C3. The test makes sense in the domain', 0, 3, 7, 6, 14,],
    ['C4. The intent of the test is easy to understand', 1, 5, 3, 6, 15,],
]

plot_likert_from_dict(plt, results, columns, 'Manually written', 2, ax1)

results = [
    ['C1. The identifiers are descriptive', 11, 5, 5, 6, 3,],
    ['C2. The test data is descriptive', 10, 4, 9, 4, 3,],
    ['C3. The test makes sense in the domain', 3, 1, 12, 10, 4,],
    ['C4. The intent of the test is easy to understand', 6, 2, 9, 8, 4,],
]

plot_likert_from_dict(plt, results, columns, 'EvoSuite', 3, ax1)

plt.savefig(f'questions.pdf', bbox_inches='tight', pad_inches=0.0)
st.pyplot(plt)

