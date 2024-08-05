import pandas as pd
from pandas import ExcelFile
from pandas import read_excel

data = pd.read_excel('C:/FST_Activities/FST_Python/Names.xlsx')
print(data)

print(data.head())

column_headers = list(data.columns)
print(column_headers)

data1 = pd.read_excel('C:/FST_Activities/FST_Python/Names.xlsx',usecols='D')
print(data1)