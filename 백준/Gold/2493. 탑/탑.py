import sys

N = int(sys.stdin.readline())
towers = list(map(int, sys.stdin.readline().split()))
answer = list()

for i in range(N):
    while answer:
        curr_tower = towers[i]
        prev_tower = answer[-1]
        if prev_tower[0] >= curr_tower: # 앞의 타워의 높이가 현재 타워와 같거나 높으면
            print(f"{prev_tower[1]}", end=" ")
            answer.append([curr_tower, i+1])
            break
        else:
            answer.pop() # 지금 타워보다 낮으면 쓸모 없으므로 제거
    if not answer: # 비었으면 추가
        answer.append([towers[i], i+1]) # 타워높이, 순서 인덱스
        print("0", end=" ")