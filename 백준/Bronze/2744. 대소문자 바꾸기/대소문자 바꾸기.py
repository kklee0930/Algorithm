n = str(input())
result = ''
for i in n:
    if i.isupper() == True:
        i = i.lower()
        result += i
    elif i.islower() == True:
        i = i.upper()
        result += i
print(result)