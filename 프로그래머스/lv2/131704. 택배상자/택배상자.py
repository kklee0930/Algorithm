from collections import deque
def solution(order):
    answer = 0
    main = deque([number for number in range(1, len(order)+1)]) # 메인 컨테이너 벨트
    temp = [] # 보조 컨테이너 벨트
    for o in order:
        if temp and o == temp[-1]: # 보조 컨테이너에 있을 경우에(가장 최근의 상자만 뺄 수 있음)
            temp.pop()
            answer += 1
        elif main[0] <= o: # 상자가 메인 컨테이너벨트에 존재하면
            while True:
                item = main.popleft() # 원하는 상자 나올때까지 popleft
                if item == o:
                    answer += 1
                    break
                temp.append(item) # 외의 상자는 보조 컨테이너에 보관
        else:
            break    
    return answer