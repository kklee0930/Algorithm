num = int(input())

dict = {}

count = 0

for i in range(num):
    cow, coord = map(int, input().split())
    if cow not in dict:
        dict[cow] = coord
    elif dict[cow] != coord:
        dict[cow] = coord
        count += 1
print(count)