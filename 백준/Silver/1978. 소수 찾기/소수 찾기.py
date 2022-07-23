from sys import stdin
n = int(stdin.readline())
lst = list(map(int, stdin.readline().split()))

count = 0

for number in lst:
    fail = 0
    if number != 1:
        for i in range(2, number):
            if number % i == 0:
                fail += 1
        if fail == 0:
            count += 1
print(count)