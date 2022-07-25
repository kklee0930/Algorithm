def prime_num(n):
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

range_list = list(range(2, 246913))
result = []

for n in range_list:
    if prime_num(n):
        result.append(n)

n = int(input())

while True:
    count = 0
    if n == 0:
        break
    for i in result:
        if n < i <= 2*n:
            count += 1
    print(count)
    n = int(input())