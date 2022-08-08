from collections import Counter

num = int(input()) # 총 사람의 수 입력받음
n = list(map(int, input().split())) # 각자 앉고 싶은 자리 입력받음(리스트로 변환)

count = 0 # 중복 횟수

n = Counter(n) # 카운터 사용

for j in n.values(): # value 값 순회
    if j > 1: # value 값이 1 보다 클 경우 중복이 발생하므로
        count += j - 1 # 먼저 앉는 한명을 제외한 나머지는 앉지 못하므로
print(count)