dict = {}
result = 0
for _ in range(10):    
    num = int(input())
    
    if num not in dict:
        dict[num] = 1
    else:
        dict[num] += 1
        
    result += num
    
avg = result // 10

max_val = max(dict.values())
for k,v in dict.items():
    if v == max_val:
        mode = k
print(avg)
print(mode)