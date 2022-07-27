n = list(input())
for i in range(len(n)):
    if n[i] == n[-i-1]:
        pass
    else:
        print(0)
        break
else:
    print(1)