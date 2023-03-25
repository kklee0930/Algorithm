def solution(n, left, right):
    answer = []
    
    while left <= right:
        # (1,1) => 1 (1,2) => 2, (1,3) => 3 인 것과 같이 max(row, col)한 값이 해당 좌표에 들어간다.
        # 따라서 row = left // n + 1, col = left % n + 1인 것을 이용하여 문제풀기
        answer.append(max(left // n + 1, left % n + 1))
        left += 1
        
    return answer