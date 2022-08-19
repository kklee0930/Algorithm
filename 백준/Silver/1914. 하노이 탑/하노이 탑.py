def hanoi(N, start, via, to):
    if N == 1:
        print(start, to, sep = ' ')
    else:
        hanoi(N-1, start, to, via)
        hanoi(1, start, via, to)
        hanoi(N-1, via, start, to)
        
N = int(input())
        
print(2**N-1)

if N <= 20:
    hanoi(N, 1, 2, 3)