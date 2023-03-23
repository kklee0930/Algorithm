def solution(citations):
    answer = []
    max_val = max(citations)
    if max_val == 0:
        return 0

    for h in range(0, max_val+1): # 0부터 최대인용횟수 iteration
        cite_cnt = 0 # h 횟수 이상 인용된 논문의 수
        
        for num in citations: # 인용된 횟수
            if num >= h: # h번 이상 인용된 논문이면
                cite_cnt += 1
                
        # h번 이상 인용 논문 h편 이상이면
        if (cite_cnt >= h):
            answer.append(h)
    
    return max(answer)