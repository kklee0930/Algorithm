def festival1(rank1):
    if 0 < rank1 < 2:
        prize1 = 5000000
    elif 1 < rank1 < 4:
        prize1 = 3000000
    elif 3 < rank1 < 7:
        prize1 = 2000000
    elif 6 < rank1 < 11:
        prize1 = 500000
    elif 10 < rank1 < 16:
        prize1 = 300000
    elif 15 < rank1 < 22:
        prize1 = 100000
    else:
        prize1 = 0
    return prize1

def festival2(rank2):
    if 0 < rank2 < 2:
        prize2 = 5120000
    elif 1 < rank2 < 4:
        prize2 = 2560000
    elif 3 < rank2 < 8:
        prize2 = 1280000
    elif 7 < rank2 < 16:
        prize2 = 640000
    elif 15 < rank2 < 32:
        prize2 = 320000
    else:
        prize2 = 0
    return prize2

for _ in range(int(input())):
    rank1, rank2 = map(int, input().split())
    print(festival1(rank1) + festival2(rank2))