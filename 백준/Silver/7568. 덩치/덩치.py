n = int(input())
info = []

for i in range(n):
    w, h = map(int, input().split())
    info.append((w,h))

for person in info:
    rank = 1
    for next_person in info:
        if person[0] < next_person[0] and person[1] < next_person[1]:
            rank += 1
    print(rank, end=' ')