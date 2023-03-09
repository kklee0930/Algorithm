def solution(dartResult):
    answer = 0
    result = [] # 점수만 들어가는 리스트
    num = '' 
    
    for i in dartResult: # 다트 점수 문자열 예: 1S2D*3T, 1D2S#10S, 1S2D**3T
        if i in ['0','1','2','3','4','5','6','7','8','9']: # i가 점수이면
            num += i # 빈 문자열 num 에 추가 (10이 나오는 경우가 있기 때문에 문자열에 숫자 추가후 정수화)
        
        else:
            if num != '': # num이 비지 않았을 경우에만 
                result.append(int(num)) # 점수 리스트에 추가
                num = '' # num 초기화
            
            if i == 'D': 
                result[-1] = result[-1]**2 # 이전 점수 더블
            elif i == 'T':
                result[-1] = result[-1]**3 # 이전 점수 트리플
            elif i == '*': 
                try: # 이전 점수와 현재 점수 2배
                    result[-2] *= 2
                    result[-1] *= 2
                except: # *이 첫번 째로 나온 경우에는 이전 점수가 없기 때문에 현재 점수에만 적용
                    result[-1] *= 2
            elif i == '#':
                result[-1] *= -1 # 이전 점수 -1 곱
                
    answer = sum(result)
    return answer