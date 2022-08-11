direction = {
    'R': (0,1),
    'L': (0,-1),
    'B': (1,0),
    'T': (-1,0),
    'RT': (-1,1),
    'LT': (-1,-1),
    'RB': (1,1),
    'LB': (1,-1),
}

k, s, n = input().split() # 킹의 위치, 돌의 위치, 입력의 횟수

# 알파벳 = 열, 숫자 = 행
kx, ky = 8 - int(k[1]), ord(k[0]) - 65 
sx, sy = 8 - int(s[1]), ord(s[0]) - 65

# 입력을 먼저 받아주기
cmd = []
for _ in range(int(n)):
    cmd.append(input())

# 입력 loop
for i in cmd: # B, L, LB, RB, LT
    # 범위 제한
    if -1 < kx + direction[i][0] < 8 and -1 < ky + direction[i][1] < 8:  
        if kx + direction[i][0] == sx and ky + direction[i][1] == sy:
            if -1 < sx + direction[i][0] < 8 and -1 < sy + direction[i][1] < 8:
                kx += direction[i][0]
                ky += direction[i][1]
                
                sx += direction[i][0]
                sy += direction[i][1]
        else:
            kx += direction[i][0]
            ky += direction[i][1]

kx = 8 - kx
ky = chr(ky + 65)
sx = 8 - sx
sy = chr(sy + 65)

print(f'{ky}{kx}')
print(f'{sy}{sx}')