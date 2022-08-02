from sys import stdin

dict = {}
lst = []

a,b = map(int, stdin.readline().split())

lst.extend(stdin.readline().split())
lst.extend(stdin.readline().split())

for i in lst:
    if i not in dict:
        dict[i] = 1
    else:
        dict[i] += 1

count = 0

for j in dict:
    if dict[j] == 1:
        count += 1

print(count)