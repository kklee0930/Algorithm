def calc(num, cnt):
    if len(num) > 1:
        cnt += 1
        t = 0
        for i in num:
            t += int(i)
        calc(str(t), cnt)
    else:
        print(cnt)
        if int(num) % 3 == 0:
            print('YES')
        else:
            print('NO')

num = input()
cnt = 0
calc(num, cnt)