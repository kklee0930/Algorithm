FBI = []
for i in range(1,6):
    agent = input()
    if 'FBI' in agent:
        FBI.append(i)
if not FBI:
    print('HE GOT AWAY!')
else:
    print(*FBI)