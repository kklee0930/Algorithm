T = int(input()) # Test Case 갯수

for _ in range(T): # Test Case만큼 Iteration
    count = 0 # 0의 갯수 초기화
    a,b = map(int, input().split()) # N 부터 M 까지의 범위에 적용될 N과 M을 받아줌
    for i in range(a, b+1): # N 부터 M 까지 iteration
        count += str(i).count('0') # i에 포함된 0의 갯수 count에 반영
    print(count)
        