temp = []
start = int(input())
temp.append(start)

max_len = 0
answer = []
for i in range(start+1):
    temp = [start]
    temp.append(i)

    while True:
        if temp[-2] - temp[-1] < 0:
            break
        else:
            temp.append(temp[-2] - temp[-1])
            
    if len(temp) > max_len:
        max_len = len(temp)
        answer = temp
        
print(max_len)
print(*answer)