a, b = map(int,input().split())
lst = []
result = 0
for i in range(1, b+1):
    for j in range(1, i+1):
        lst.append(i)
        
print(sum(lst[a-1:b]))