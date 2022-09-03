# 들어간 차량
enter_dict = {}

# 나온 차량
exit_dict = {}

count = 0 

num = int(input())

for i in range(num):
    car_num = input()
    enter_dict[i] = car_num
    
for j in range(num):
    car_num = input()
    exit_dict[car_num] = j

for curr_car in range(1,num):
    for prev_car in range(0, curr_car):
        # 먼저 입장한 차의 퇴장이 더 늦게 입장한 차의 퇴장보다 늦으면 추월
        if exit_dict[enter_dict[prev_car]] > exit_dict[enter_dict[curr_car]]:
            count += 1
            break
print(count)