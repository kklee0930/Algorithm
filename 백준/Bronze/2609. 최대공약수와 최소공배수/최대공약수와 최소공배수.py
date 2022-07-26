a,b = map(int,input().split())
for i in range(1, min(a,b)+1):
    if a % i == 0 and b % i == 0:
        lcm = i * (a//i) * (b//i)
        gcd = i
print(gcd)
print(lcm)