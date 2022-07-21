T = int(input())
for tc in range(1, T+1):
    a = input()
    b = ''.join(reversed(a))
    if a == b:
        print(f'#{tc} 1')
    else:
        print(f'#{tc} 0')