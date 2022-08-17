def change(num):
    if switch[num] == 0:
        switch[num] = 1
    else:
        switch[num] = 0
    return

num_switch = int(input())
switch = [-1] + list(map(int, input().split()))
student = int(input())
     
for i in range(student):
    gender, num = map(int, input().split())
    
    if gender == 1:
        for i in range(num, num_switch+1, num):
            change(i)
    
    else:
        change(num)
        for j in range(num_switch // 2):
            if num - j < 1 or num + j > num_switch:
                break
            if switch[num-j] == switch[num+j]:
                change(num-j)
                change(num+j)  
            else:
                break

for i in range(1, num_switch + 1):
    print(switch[i], end=' ')
    if i % 20 == 0:
        print()