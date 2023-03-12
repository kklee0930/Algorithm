def solution(cards1, cards2, goal):
    for word in goal: # goal에서의 iteration
        if len(cards1) >= 1: # 카드1에 해당 단어가 존재할경우
            if word == cards1[0]: # 리스트 첫번째 원소가 word를 같은지 체크 후
                cards1.remove(cards1[0]) # 같다면 삭제 후 다음 loop 진행
                continue
            
        if len(cards2) >= 1:
            if word == cards2[0]:
                cards2.remove(cards2[0])
                continue
            else: # cards1과 cards2에 모두 존재하지 않는다면 조건에 부합하여 불가능처리
                return 'No'
        
        else: # cards1과 cards2에 모두 존재하지 않는다면 조건에 부합하여 불가능처리
            return 'No'
        
    return 'Yes'