l = []
for i in range(1, 11):
    a = int(input())
    l.append(a % 42)

ll = []
count = 1
for i in l:
    if i not in ll:
        ll.append(i)
print(len(ll))