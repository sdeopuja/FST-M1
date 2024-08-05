print('Hello World')
myVariable = 5
mySingleComment = "Single Comment"
myMultiComment = "Multiple Comment"
print(myVariable)
myVariable = 'Sneha'
print(myVariable)
#Single line Comment
print(mySingleComment)

""" Multiple line Comment 
print(myMultiComment)
print(Sdsdsdsdsds)

"""
a = """Multiple line Comment"""
b = 1
#c = a+b
x = "line" in a
y = "line" not in a
z= myMultiComment+ mySingleComment
age = 20
place = "Pune"
strText = "My name is Raj , I stay in {1} and I am {0} years old.."
print(a)
print(a[1])
print(a[1:5])
print(a.lower())
print(a.upper())
print(a.replace("M","S"))
print(a.split(" "))
print(x)
print(y)
print(z)
# print(c)
print(strText.format(age,place))
x1 = int(1)
x2 = int(1.43333)
x3 = int("5")
y1 = float(2.0)
y2 = float(2444)
y3 = float("3.5433")
z1 = str("1")
z2 = str("1.010101")
z3 = str("string")
print(x1,x2,x3,y1,y2,y3,z1,z2,z3)
userName = input("Please enter name:")
print("You enter :" + userName)