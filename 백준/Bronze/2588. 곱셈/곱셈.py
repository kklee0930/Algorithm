a = int(input())
b = input()

zero = ''
result = 0

for i in b[::-1]:
    if zero == '':
        print(int(i)*a)
        result += int(i)*a
        zero += '0'
    else:
        print(int(i)*a)
        result += int(str(int(i)*a) + zero)
        zero += '0'
        
print(result)