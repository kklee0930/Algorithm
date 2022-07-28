lst = []
dict = {}

for _ in range(int(input())):
    lst.append(int(input()))

for elem in lst:
    if elem in dict:
        dict[elem] += 1
    else:
        dict[elem] = 1

result = sorted(dict.items(), key=lambda x: (-x[1], x[0]))
print(result[0][0])