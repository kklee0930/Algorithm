def solution(k, score):
    honors = []
    answer = []
        
    for i in range(len(score)):
        
        if len(honors) < k: # k일 동안은 무조건 모두 명예의 전당에 추가
            honors.append(score[i])
            answer.append(min(honors)) # 발표점수
            
        else:
            if score[i] > min(honors): # 점수가 최저점보다 클 경우
                honors.remove(min(honors)) # 최저점 제거
                honors.append(score[i]) # 점수 추가
                answer.append(min(honors)) # 발표점수
            else:
                answer.append(min(honors)) # 발표점수
    
    return answer