def solution(n, t, m, p):
    answer = ''
    res = ''
    
    def generator(i, n): # 진법 계산기
        if i == 0:
            return str(0)
        dic = {10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
        li = []
        while i:
            if i % n in range(10, 16): # 10~15일 경우 A~F로 치환
                li.insert(0, dic[i%n])
            else:
                li.insert(0, str(i % n))
            i = i // n
        return ''.join(li)
        
    for i in range(t*m):
        res += generator(i, n) # 진법 계산값 res에 추가
    
    for i in range(p-1, len(res), m): # 총인원 m 단위로 iteration
        answer += res[i]
        if len(answer) >= t:
            return answer
