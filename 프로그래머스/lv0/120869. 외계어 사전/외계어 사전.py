def solution(spell, dic):
    for word in dic: # ['sod', 'eocd', 'qixm'...]
        cnt = 0
        for char in spell: # ['p', 'o', 's']
            if char in word: # 'p' in 'sod'
                cnt += 1
                if cnt == len(spell):
                    return 1
    return 2