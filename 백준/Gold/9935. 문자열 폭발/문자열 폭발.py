str_ = input()
bomb = input()
target = []
for char in str_:
    target.append(char)
    if ''.join(target[-len(bomb):]) == bomb:
        for i in range(len(bomb)):
            target.pop()
            
result = ''.join(target)
if result == '':
    print('FRULA')
else:
    print(result)