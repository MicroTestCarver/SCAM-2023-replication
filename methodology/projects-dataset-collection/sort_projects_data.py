import pandas as pd
import numpy as np
from sklearn import preprocessing


def score(star, fork, commit, test, size):
    return np.average([star, fork, commit, test, size], weights=([10, 4, 1, 7, -3])) * 1000


INPUT_CSV = "./data/selected_projects_add.csv"  # the input file: csv file of selected projects
OUTPUT_CSV = "./data/selected_projects_sorted.csv"  # the collected data will be stored here

df = pd.read_csv(INPUT_CSV)

min_max_scaler = preprocessing.MinMaxScaler()

numeric_cols = df.select_dtypes(include=[np.number]).columns
scaled_df = pd.DataFrame(min_max_scaler.fit_transform(df[numeric_cols].values), columns=numeric_cols)

df['score'] = scaled_df.apply(lambda row: score(row['Stargazers'],
                                                row['Forks'], row['Commits'], row['test'], row['Size']), axis=1)

sorted_df = df.sort_values(by=['score'], ascending=False)
sorted_df.to_csv(OUTPUT_CSV, index=False)

print("Finish sorting projects")
