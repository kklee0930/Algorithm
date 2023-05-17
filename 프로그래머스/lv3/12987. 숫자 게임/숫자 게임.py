import heapq
def solution(A, B):
    answer = 0
    # A와 B를 모두 정렬하여 A를 기준으로 A[i]와 B[i]의 크기를 비교하는 것으로 시작.
    A.sort()
    B.sort()
    l = len(A)
    
    idx = 0
    for i in range(len(A)):
        while idx <= l-1: # B의 인덱스 끝에 다다르면 자동으로 종료
            if B[idx] > A[i]: # B가 A보다 크면 A와 B의 인덱스 모두 +1
                answer += 1
                idx += 1
                break
            idx += 1 # 아니라면 B의 인덱스만 증가시키고 다시 비교
        if idx > l-1: # B의 인덱스 끝에 다다르면 자동으로 종료
            return answer
    return answer
                