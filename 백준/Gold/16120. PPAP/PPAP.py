str_ = input()

result = []

for char in str_:
    result.append(char)
    if len(result) >= 4:
        concat = ''.join(result[-4:])
        if concat == 'PPAP':
            result[-4:] = 'P'
            
if ''.join(result) == 'PPAP' or ''.join(result) == 'P':
    print('PPAP')
else:
    print('NP')