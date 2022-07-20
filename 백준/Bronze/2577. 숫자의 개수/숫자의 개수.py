result = 1

for i in range(3):
    a = int(input())
    result *= a

result = str(result)
num = 0

for i in result:
    while num <= 9:
        count = result.count(str(num))
        print(count)
        num += 1