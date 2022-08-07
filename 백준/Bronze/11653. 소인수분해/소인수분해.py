num = int(input())
i = 2
lst = []
while num > 1:
    if num % i == 0:
        num = num // i
        lst.append(i)
    elif num % i != 0:
        i += 1
        
for i in lst:
    print(i)