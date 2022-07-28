lst = []
dict = {}
for _ in range(int(input())):
    lst.append(input())
    
for title in lst:
    if title not in dict:
        dict[title] = 1
    else:
        dict[title] += 1
        
result = []

max_val = max(dict.values())

for k,v in dict.items():
    if v == max_val:
        result.append(k)

print(min(result))