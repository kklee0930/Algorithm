def solution(ingredient):
    answer = 0
    result = []
    
    for item in ingredient: 
        result.append(item) # 재료를 하나씩 리스트에 추가
        if len(result) >= 4: # 길이가 4 이상이면
            if result[-4:] == [1, 2, 3, 1]: # 마지막 원소 4개로 햄버거 완성가능한지 확인
                answer += 1
                for _ in range(4): # 사용한 재료 리스트에서 제거
                    result.pop()
    return answer