from collections import Counter

for _ in range(int(input())):
    a,b = input().split()

    a_cnt = Counter(a)
    b_cnt = Counter(b)
    
    if a_cnt == b_cnt:
        print(f'{a} & {b} are anagrams.')
    else:
        print(f'{a} & {b} are NOT anagrams.')