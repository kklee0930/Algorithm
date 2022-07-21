T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    count = 0
    s = set()

    while len(s) < 10:
        count += 1
        result = N * count
        for char in str(result):
            s.add(char)
    print(f'#{test_case} {count*N}')