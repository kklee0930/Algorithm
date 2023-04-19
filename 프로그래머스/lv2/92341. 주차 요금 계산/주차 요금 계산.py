import math
def solution(fees, records):
    dic = {}
    res = {}
    answer = []
    
    for rec in records: # 주차시간 구하기
        data = rec.split()
        if data[1] not in res:
            res[data[1]] = 0
        time = data[0].split(':') # 차랑 출입 시간
        if time[0] == '23' and time[1] == '59': # 23시 59분 제외
            continue
        minutes = int(time[0])*60 + int(time[1]) # 출입시간을 분으로 변경
        
        if data[2] == 'IN': # 입차
            dic[data[1]] = minutes # dic에 {입차번호: 입차시간(분)}
        elif data[2] == 'OUT': # 입차기록이 존재함과 동시에 출차일 경우에
            res[data[1]] += minutes - dic[data[1]] # 출차시간(분) - 입차시간(분)
            del dic[data[1]]

    if dic: # 입차기록만 남아있는 경우 23:59에 출차한 것으로 간주
        for k, v in dic.items():
            res[k] += (23*60 + 59) - v
    res = dict(sorted(res.items()))

    for k, v in res.items(): 
        if v > fees[0]: # 기본시간 초과
            answer.append(fees[1] + math.ceil((v - fees[0]) / fees[2]) * fees[3])
        else: # 기본시간
            answer.append(fees[1])
            
    return answer