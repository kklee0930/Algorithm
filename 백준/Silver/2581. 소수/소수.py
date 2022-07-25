start = int(input())
end = int(input())
prime_num = []
fail = 0

for i in range(start, end+1):
    fail = 0
    if i > 1:
        for j in range(2, i):
            if i % j == 0:
                fail += 1
                break
        if fail == 0:
            prime_num.append(i)
            
if len(prime_num) == 0:
    print(-1)
else:
    print(sum(prime_num))
    print(min(prime_num))