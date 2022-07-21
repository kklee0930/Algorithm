T = int(input())
for tc in range(1, T+1):
    h1,m1,h2,m2 = map(int, input().split())
    hr = (h1+h2)%12
    div = (m1+m2)//60
    m = (m1+m2)%60
    print(f'#{tc} {hr+div} {m}')
