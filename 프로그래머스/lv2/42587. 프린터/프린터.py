from collections import deque
def solution(priorities, location):
    answer = 0
    # 같은 우선순위를 가지는 원소가 존재할 수 있으므로 인덱스 값을 부여하여 해당 원소를 판별한다
    dq = deque(list(enumerate(priorities))) # [(0,2),(1,1),(2,3),(3,2)] (인덱스값, 우선순위값)
    target = dq[location][0] # 해당 원소의 인덱스 값

    cnt = 0 # 인쇄횟수
    while True:
        max_ = max(dq, key=lambda x: x[1])[1] # 가장 우선순위가 높은 원소

        if dq[0][1] == max_: # 우선순위가 max_와 같으면
            cnt += 1 # 인쇄 +1
            if dq.popleft()[0] == target: # 인쇄한 원소의 인덱스값이 target과 같으면 리턴
                return cnt
        else:
            dq.append(dq.popleft())
        