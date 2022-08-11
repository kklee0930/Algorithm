score = list(map(int, input().split()))
if sum(score) >= 100:
    print('OK')
else:
    if min(score) == score[0]:
        print('Soongsil')
    elif min(score) == score[1]:
        print('Korea')
    else:
        print('Hanyang')