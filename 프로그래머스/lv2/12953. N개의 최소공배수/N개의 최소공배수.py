def solution(arr):
    max_ = max(arr)

    num = 2 # 원소에 곱하는 수
    while True:
        max_val = max_ * num # 리스트의 최대의 배수가 나머지 원소에 모두 나누어 떨어지면 최소공배수
        
        for n in arr:
            if max_val % n != 0:
                num += 1
                break
                
        else:
            return max_val