from itertools import permutations
def solution(k, dungeons):
    li = [n for n in range(len(dungeons))]
    perm = permutations(li)
    perm = list(map(list, perm)) # 순열 2차원 배열 형태로 생성
    
    max_cnt = 0 # 최대 탐험한 던전 수
    for c in perm: # 순열 [1,2,3], [2,1,3]... (이 때 리스트의 숫자는 dungeons의 인덱스를 뜻한다.)
        fatigue, cnt = k, 0 # 잔여 피로도, 탐험 횟수
        for i in c: # 1,2,3 // dungeons[1] = [80,20]
            if fatigue <= 0:
                break
            if dungeons[i][0] > fatigue:
                continue
            else:
                fatigue -= dungeons[i][1]
                cnt += 1
                    
        if cnt > max_cnt:
            max_cnt = cnt
                
    return max_cnt