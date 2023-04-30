def solution(a, b, c, d):
    li = [a,b,c,d]
    cnts = [li.count(i) for i in li]
    
    if max(cnts) == 4:
        return 1111 * a
    elif max(cnts) == 3:
        p = cnts.index(3)
        q = cnts.index(1)
        return (10 * li[p] + li[q])**2
    elif cnts == [2,2,2,2]: # 두 개씩 같은 값 p,q
        p, q = list(set(li))[0], list(set(li))[1]
        return (p + q) * abs(p - q)
    elif cnts.count(1) == 2 and max(cnts) == 2: # p가 두개, 나머지 각자 다른 숫자 하나씩
        p = cnts.index(2) # 두번 나온 p를 먼저 구하고
        li = [li[i] for i in range(len(cnts)) if cnts[i] != 2] # 두번 나온 p를 li에서 제외
        q, r = li[0], li[1]
        return q * r
    else:
        return min(li)