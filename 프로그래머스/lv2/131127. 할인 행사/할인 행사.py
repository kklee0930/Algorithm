def solution(want, number, discount):
    answer = 0
    
    for i in range(0, len(discount)-9): # 1일부터 전체일-10일 (1~5일)
        items = discount[i:i+10] # i일부터 i+10일
        for i in range(len(want)): # want의 물품수량이 맞는지 체크
            if items.count(want[i]) != number[i]:
                break
        else:
            answer += 1
        
    return answer