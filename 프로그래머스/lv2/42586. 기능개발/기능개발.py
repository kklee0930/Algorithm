from collections import deque
def solution(progresses, speeds):
    answer = []
    dq = deque(progresses)
    speeds = deque(speeds)
        
    while dq:
        for i in range(len(speeds)):
            remains = 100 - dq[0] # 첫번 째 작업을 완료하기까지 남은 일수
            day = remains // speeds[0] # 작업일수 = 남은일수 // 작업 시간
            if remains % speeds[0] != 0: # 나머지 작업 존재 시 끝마치기 위하여 +1일
                day += 1
                
            for i in range(len(speeds)):
                dq[i] += (speeds[i] * day)
        
        if dq[0] >= 100: # 작업 완료시
            cnt = 0
            while dq and dq[0] >= 100: 
                dq.popleft()
                speeds.popleft()
                cnt += 1 # 완료한 작업수 +1
            answer.append(cnt)
            
    return answer