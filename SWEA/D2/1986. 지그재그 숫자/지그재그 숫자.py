T = int(input())

for test_case in range(1, T + 1):
    number = 0
    a = int(input())
    for i in range(1, a+1):
        if i % 2 != 0: #홀수일경우
            number += i
        elif i % 2 == 0: #짝수일경우
            number -= i
    print(f'#{test_case} {number}')