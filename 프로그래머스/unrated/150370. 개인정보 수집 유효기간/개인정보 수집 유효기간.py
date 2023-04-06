def solution(today, terms, privacies):
    answer = []
    dic = {} # 약관종류: 유효기간
    tod = list(map(int, today.split('.'))) # ['2022', '05', '19']
    tod_cnt = ((tod[0]-1)*28*12) + ((tod[1]-1)*28) + (tod[2]) # 총 일수 계산(년도-1 * 일수, 월 * 일수, 일수)
    
    for term in terms: # 약관종류: 유효기간 해시화
        term = term.split()
        dic[term[0]] = int(term[1])
        
    for i in range(len(privacies)):
        pr = privacies[i].split()
        date, policy = pr[0], pr[1] # 개인정보 수집일자, 약관종류
        y, m, d = int(date.split('.')[0]), int(date.split('.')[1]), int(date.split('.')[2])
        d_cnt = sum([(y-1)*12*28, (m-1)*28, d]) # 총 일수 계산
        d_cnt += (dic[policy] * 28)

        if tod_cnt >= d_cnt:
            answer.append(i+1)

    return answer