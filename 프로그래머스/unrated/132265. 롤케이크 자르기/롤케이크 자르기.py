from collections import Counter
def solution(topping):
    answer = 0
    t1 = Counter(topping) # 토핑 전체를 해시화
    t2 = set()
    for i in topping: # iteration 통한 i를 t1에서 하나씩 빼고 t2에 더한다
        if i in t1:
            t1[i] -= 1
            if t1[i] == 0:
                del t1[i]
        if i not in t2:
            t2.add(i)
        
        if len(t1) == len(t2): # set과 해시의 길이가 같아지면 공평하게 나눈 것
            answer += 1
    return answer