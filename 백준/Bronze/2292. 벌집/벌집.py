goal = int(input())
total = 1
count = 1

while goal > total:
    total += count * 6
    count += 1
print(count)