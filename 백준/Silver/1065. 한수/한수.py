N = int(input())
count = 0
for i in range(1, N+1): 
    if i <= 9:
        count += 1
    elif i <= 99:
        count += 1
    elif i >= 100: 
        i = str(i)
        if (int(i[0]) + int(i[2])) / 2 == int(i[1]):
            count += 1
print(count)