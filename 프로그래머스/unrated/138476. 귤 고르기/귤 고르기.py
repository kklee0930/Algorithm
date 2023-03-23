def solution(k, tangerine):
    answer = 0
    dict_ = {}

    # 귤의 {크기: 갯수} 로 해시 생성
    for n in tangerine:
        if n not in dict_:
            dict_[n] = 1
        else:
            dict_[n] += 1
            
    amount = list(dict_.values()) # 크기별 갯수만 뽑아서 리스트로 변환
    amount.sort() # 시간 단축 위해 정렬
    
    while k > 0: # k가 음수나 0이되면 상자가 꽉찬 것
        k -= amount[-1] # k - 가장 많은 크기의 갯수
        amount.pop()
        answer += 1 # 해당 크기의 귤은 모두 상자에 들어간 것으로 간주
    return answer