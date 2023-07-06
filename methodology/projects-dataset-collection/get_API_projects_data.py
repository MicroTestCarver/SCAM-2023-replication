import pandas as pd
from tqdm import tqdm
from github_quality_analytics.quality_analytics import FileUsage, CountFileUsage
from github_quality_analytics.instance_manager import InstanceManager

tqdm.pandas()

# place enough access tokens here, so that you will not reach the API limit
KEYS = ['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', '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']

InstanceManager(KEYS)

INPUT_CSV = "./data/selected_projects.csv"  # the input file: csv file of selected projects
OUTPUT_CSV = "./data/selected_projects_add.csv"  # the collected data will be stored here

df = pd.read_csv(INPUT_CSV)

spring_usage = FileUsage('application.properties')
df['spring'] = df['Name'].progress_apply(lambda x: spring_usage.gather_data(x)[0])
df.to_csv(OUTPUT_CSV, index=False)

df = df[df['spring'] == '1']

# Check project does have tests or not
test = CountFileUsage("[\w\/'-]*src\/test\/[\w\/'-]*")
df['test'] = df['Name'].progress_apply(lambda x: test.gather_data(x, "", True)[0])
df.to_csv(OUTPUT_CSV, index=False)

# df = df[df['test'] == '1']

# ASAT Tools
checkstyle_usage = FileUsage('checkstyle')
df['checkstyle'] = df['Name'].progress_apply(lambda x: checkstyle_usage.gather_data(x)[0])
df.to_csv(OUTPUT_CSV, index=False)

# Build Tools
maven_usage = FileUsage('pom.xml')
df['maven'] = df['Name'].progress_apply(lambda x: maven_usage.gather_data(x)[0])
df.to_csv(OUTPUT_CSV, index=False)

gradle_usage = FileUsage('build.gradle')
df['gradle'] = df['Name'].progress_apply(lambda x: gradle_usage.gather_data(x)[0])
df.to_csv(OUTPUT_CSV, index=False)

gradle_usage_on_root = FileUsage('build.gradle', only_root=True)
df['gradle_on_root'] = df['Name'].progress_apply(lambda x: gradle_usage_on_root.gather_data(x)[0])
df.to_csv(OUTPUT_CSV, index=False)

maven_usage_on_root = FileUsage('pom.xml', only_root=True)
df['maven_usage_on_root'] = df['Name'].progress_apply(lambda x: maven_usage_on_root.gather_data(x)[0])
df.to_csv(OUTPUT_CSV, index=False)

print("Finish getting additional data from GithubAPI.")
