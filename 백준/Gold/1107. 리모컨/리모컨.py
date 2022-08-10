from sys import stdin
input = stdin.readline

# 사용 가능한 버튼으로만 최대한 목표에 가까운 채널로 이동한 후에 + -로 미세조정하는 것이 핵심
target = int(input())
broken_cnt = int(input())

broken = list(map(int,input().split()))

# 리모콘 + -만 사용해서 조작할 경우 횟수
min_ = abs(100 - target)

# 범위에서 loop 돌며
for number in range(1000001):
    number = str(number)
    
    # number에 고장난 숫자가 포함되어 있으면 break
    for i in range(len(number)):
        if int(number[i]) in broken:
            break
        
        elif i == len(number) - 1:
            min_ = min(min_, abs(int(number) - target) + len(number))
    
print(min_)