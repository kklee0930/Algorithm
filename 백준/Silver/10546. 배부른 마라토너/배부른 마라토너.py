from sys import stdin
dict = {}
n = int(stdin.readline())

for i in range(n):
    name = stdin.readline()
    if name not in dict:
        dict[name] = 1
    else:
        dict[name] += 1
        
for j in range(n-1):
    finish = stdin.readline()
    if finish in dict:
        dict[finish] -= 1
    
for k,v in dict.items():
    if v == 1:
        print(k)
