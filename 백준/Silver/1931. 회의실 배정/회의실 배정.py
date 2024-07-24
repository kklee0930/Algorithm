import sys

input = sys.stdin.readline

N = int(input().strip()) # 회의의 수
meetings = []
for _ in range(N):
    meetings.append(list(map(int, input().strip().split())))

# 빨리 끝나는 순, 빨리 시작하는 순으로 회의 정렬
meetings.sort(key=lambda x: (x[1], x[0]))

prev_end = 0
cnt = 0

for meeting in meetings:
    new_start, new_end = meeting[0], meeting[1]
    
    # 다음 미팅 시작 시간이 이전 미팅 종료 시간과 겹치지 않을 때에만 +1
    if new_start >= prev_end:
        prev_end = new_end
        cnt += 1
        
print(cnt)