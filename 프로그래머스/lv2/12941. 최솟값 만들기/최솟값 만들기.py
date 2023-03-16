def solution(A,B):
    # 가장 작은수와 가장 큰 수를 곱하는 것이 핵심
    answer = 0
    A_ = sorted(A) 
    B_ = sorted(B, reverse=True)
    
    for i in range(len(A_)): 
        answer += A_[i] * B_[i]
    return answer