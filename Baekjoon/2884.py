a,b = map(int, input().split())

if b-45 < 0:
    if a - 1 < 0:
        print(23, 60 - 45 + b)
    else:
        print(a - 1, 60 - 45 + b)
else:
    print(a, b - 45)