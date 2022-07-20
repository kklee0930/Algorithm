T = int(input())
l = []

for i in range(1, T+1):
    a = input()
    l.append(a)

for i in l: # ['OOXXOXXOOO', 'OOXXOXXOOO'] 리스트 for 문
    result = 0
    idx = 0
    sum_list = []
    for j in i: # 'OOXXOXXOOO' 문자열 for 문
        if j == 'O':
            idx += 1
            result += idx
        elif j != 'O':
            idx  = 0
            result += idx
    print(result)