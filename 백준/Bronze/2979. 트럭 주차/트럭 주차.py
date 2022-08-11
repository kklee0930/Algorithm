A,B,C = map(int,input().split())

#입력으로 주어지는 시간은 1과 100 사이이다.
time_table = [0]*101

for _ in range(3):
    arrival, departure = map(int,input().split())
    
    #인덱스는 0부터 시작하기 때문에 -1 적용
    #타임테이블의 각 인덱스는 시점이므로 시점에 차가 몇대가 있는지 입력해준다.
    for i in range(arrival-1, departure-1):
        time_table[i] += 1

result = 0

for num in time_table:
    if num == 1:
        result += num * A
    elif num == 2:
        result += num * B
    elif num == 3:
        result += num * C
        
print(result)