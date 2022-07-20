T = int(input())
num = list(map(int, input().split()))

max_num = max(num)
l = []
for i in num:
    l.append(i / max_num * 100)
print((sum(l) / len(l)))
