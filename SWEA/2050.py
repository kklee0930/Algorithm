input_str = str(input())
l = []
for i in input_str:
    i = ord(i) - 64
    l.append(i)
for i in l:
    print(i, end=' ')