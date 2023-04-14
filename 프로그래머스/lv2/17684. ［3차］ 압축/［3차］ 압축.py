from collections import deque
def solution(msg):
    answer = []
    dic = {}
    alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    for i in range(len(alphabet)):
        dic[alphabet[i]] = i+1
    
    dq = deque(msg)
    while dq:
        w = dq.popleft() # 현재입력
        if dq and w+dq[0] in dic: # 사전에 문자합이 존재할 경우
            w += dq.popleft()
            while dq and (w + dq[0]) in dic: # 존재하지 않는 문자합이 나올 때까지 반복
                w += dq.popleft()
        answer.append(dic[w])
        if dq:
            dic[w+dq[0]] = len(dic) + 1
        
    return answer