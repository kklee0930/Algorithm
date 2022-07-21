T = int(input())
for tc in range(1, T+1):
    S,R = input().split()
    S = int(S)
    R = str(R)
    sum = ''
    for char in R:
        sum = sum + (char * S)
    print(sum)