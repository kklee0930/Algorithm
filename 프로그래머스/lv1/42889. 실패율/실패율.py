def solution(N, stages):
    answer = []
    
    for i in range(1, N+1): # 스테이지 1부터 N스테이지 까지 iteration
        fail = 0 # 실패한 유저수
        for j in stages: # 유저들의 클리어한 스테이지 리스트 iteration
            if i >= j: # 유저가 현재 체크중인 스테이지를 통과하지 못했으면
                fail += 1 # 실패 유저수 += 1
        try:
            failure_rate = fail / len(stages) # 실패율 계산
        except:
            failure_rate = 0 # 런타임 에러시 실패율은 0
            
        answer.append([i, failure_rate]) # [실패 스테이지, 실패율]을 answer 리스트에 추가
        stages = [elem for elem in stages if elem != i] # 스테이지 리스트에서 iteration 완료한 스테이지 제거
        
    answer.sort(key=lambda x: (-x[1], x[0])) # 실패율 내림차순으로 정렬, 같은 실패율 고려한 스테이지 번호 오름차순 정렬
    answer = [x[0] for x in answer] # 스테이지만 모아서 리스트 생성
    return answer