import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter

FirstName =  ['Satvik','Avinash','Lahri']
LastName =  ['Shah','Kati','Rath']
Email =  ['satshah@example.com','avinashkat@exmple.com','lahrath@example.com']
PhoneNumber =  ['4563799873','6578769576','8877996655']
columns=['FirstName','LastName','Email','PhoneNumner']

df = pd.DataFrame(list(zip(FirstName,LastName,Email,PhoneNumber)), columns=columns)
print(df)
writer = ExcelWriter('Names.xlsx')

df.to_excel('Names.xlsx')

writer.close