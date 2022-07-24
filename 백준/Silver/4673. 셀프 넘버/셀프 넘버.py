num_range = set(range(1, 10001))
self_num = set()

for i in num_range: # 632
    for j in str(i): # 6, 3, 2
        i += int(j) # 632 + 6 + 3 + 2
    self_num.add(i)

num_range -= self_num
result = sorted(num_range)
for i in result:
    print(i)