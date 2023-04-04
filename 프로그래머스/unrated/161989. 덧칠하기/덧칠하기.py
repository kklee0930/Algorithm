def solution(n, m, section):
    
    answer = 0
    while section:
        cnt = section[0] + m-1 # 페인트가 칠해져 있지 않은 첫 위치에서 m만큼 페인트칠
        answer += 1 # 페인트칠 횟수
        for i in range(len(section)):
            if section[i] > cnt: # 페인트칠이 되지 않은 구간이 나오면 그 구간의 시작 지점을 구하고
                idx = i
                break
        else: # 남아 있는 숫자가 전부 cnt보다 작으면 페인트칠이 완료된 것
            return answer
                
        section = section[i:] # 페인트칠이 되지 않은 구역을 슬라이싱으로 재정의
    
    return answer