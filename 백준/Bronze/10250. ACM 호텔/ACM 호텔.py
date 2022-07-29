T = int(input())
for i in range(1, T+1):
    H,W,N = map(int, input().split())
    y = N % H
    x = (N // H) + 1
    
    if N % H == 0:
        y = H
        x = N // H
    print(x+ 100*y)