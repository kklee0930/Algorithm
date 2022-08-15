N, K = map(int, input().split()) # 온도 측정한 전체 날짜의 수, 연속적인 K일
temp_lst = list(map(int, input().split())) # 측정한 온도의 수열

answer = 0 
start = 0

test = [sum(temp_lst[:K])]

for i in range(len(temp_lst)-K):
    test.append(test[-1] - temp_lst[i] + temp_lst[i+K])
print(max(test))