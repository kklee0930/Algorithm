msg = input().replace(' ','')

happy_cnt = 0
sad_cnt = 0

for i in range(len(msg)):
    if i + 2 >= len(msg):
        break
    if msg[i] == ':':
        if msg[i+1] + msg[i+2] == '-)':
            happy_cnt += 1
        elif msg[i+1] + msg[i+2] == '-(':
            sad_cnt += 1

if happy_cnt == 0 and sad_cnt == 0:
    print('none')
else:
    if happy_cnt > sad_cnt:
        print('happy')
    elif happy_cnt < sad_cnt:
        print('sad')
    else:
        print('unsure')