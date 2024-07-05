import sys

midgets = list()

for _ in range(9):
    midgets.append(int(sys.stdin.readline()))

extra_height = sum(midgets) - 100

for i in range(9):
    for j in range(i + 1, 9):
        if midgets[i] + midgets[j] == extra_height:
            n1, n2 = midgets[i], midgets[j]
            midgets.remove(n1)
            midgets.remove(n2)
            break
    if len(midgets) < 9:
        break
            
midgets.sort()

for height in midgets:
    print(height)