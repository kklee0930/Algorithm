a,b = map(int, input().split())
a -= 1
b -= 1
y = abs((a % 4) - (b % 4))
x = abs((a // 4) - (b // 4))
print(x + y)