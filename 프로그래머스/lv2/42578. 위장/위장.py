import math
def solution(clothes):
    answer = 1
    dict_ = {k:[] for _, k in clothes} # 의류 종류에 따라 빈 리스트를 가지는 해시 생성
    for v, k in clothes:
        dict_[k].append(v) # 의류 종류 key에 의류 이름 저장
        
    for v in dict_.values():
        answer *= len(v) + 1 # 착용한 옷의 종류가 1가지여도 되기 때문에 +1
        
    return answer - 1 # 옷을 입지 않는 경우 -1