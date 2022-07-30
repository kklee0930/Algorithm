from collections import Counter
from sys import stdin

numbers = []
n = int(stdin.readline())
for i in range(n):
    numbers.append(int(stdin.readline()))

numbers.sort()

#산술 평균
print(round(sum(numbers) / len(numbers)))

#중앙값
print(numbers[len(numbers) // 2])

#최빈값
numbers_cnt = Counter(numbers).most_common()
if len(numbers) > 1:
    if numbers_cnt[0][1] == numbers_cnt[1][1]:
        print(numbers_cnt[1][0])
    else:
        print(numbers_cnt[0][0])
else:
    print(numbers_cnt[0][0])

#범위
print(max(numbers) - min(numbers))