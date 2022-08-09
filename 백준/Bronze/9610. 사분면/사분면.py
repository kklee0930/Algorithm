num = int(input())

AXIS = 0
Q1 = 0
Q2 = 0
Q3 = 0
Q4 = 0

for i in range(num):
    a,b = map(int, input().split())
    if a == 0 or b == 0:
        AXIS += 1
    elif a > 0 and b > 0:
        Q1 += 1
    elif a > 0 and b < 0:
        Q4 += 1
    elif a < 0 and b > 0:
        Q2 += 1
    else:
        Q3 += 1
print(f'Q1: {Q1}\nQ2: {Q2}\nQ3: {Q3}\nQ4: {Q4}\nAXIS: {AXIS}')