for _ in range(int(input())):
    n = input().split()
    
    for i in range(len(n)):
        n[i] = n[i][::-1]
        print(n[i], end=' ')