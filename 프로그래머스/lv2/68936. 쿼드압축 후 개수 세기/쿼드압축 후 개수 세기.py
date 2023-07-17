def solution(arr):
    answer = [0, 0] # 0갯수, 1갯수
    N = len(arr) # NxN 배열에서 N 값
    
    def recursion(r, c, N):
        init_val = arr[r][c] # 시작 값
        
        for i in range(r, r+N):
            for j in range(c, c+N):
                if arr[i][j] != init_val: # 하나라도 시작 값과 다르면 내부의 모든 수가 같은 값이 아님
                    
                    # 쪼개기 실시
                    N = N // 2 # iteration 범위를 절반 만큼 줄임
                    recursion(r, c, N)
                    recursion(r+N, c, N)
                    recursion(r, c+N, N)
                    recursion(r+N, c+N, N)
                    return
                
        answer[init_val] += 1 # 내부 수가 모두 같으면 +1
                

    recursion(0, 0, N)
    return answer