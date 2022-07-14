'''1, 2, 3 ... 을 계속 더해 나갈 때,
그 합이 입력한 정수(0 ~ 1000)보다 같거나 작을 때까지만
계속 더하는 프로그램을 작성해보자.'''

input_number = int(input())
sum = 0
i = 0
while sum < input_number:
    sum += i
    if sum >= input_number:
        print(i)
    else:
        i += 1