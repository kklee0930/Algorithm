def solution(number, limit, power):
    answer = 0
    power_list = [] # 각 기사의 공격력 수치
        
    def get_count(n):
        cnt = 0 # 약수의 갯수
        for num in range(1, int(n**(1/2))+1): # 1부터 제곱근까지를 범위로 잡는다
            if n % num == 0: # 나누어 떨어지면 약수
                cnt += 1 
                if num**2 != n: # 나누어 떨어진 약수의 제곱값 또한 나누어 떨어진다
                    cnt += 1
            if cnt > limit: # 약수의 갯수가 limit 초과 시
                return power
        return cnt
    
    for n in range(1, number+1):
        power_list.append(get_count(n))
    answer = sum(power_list)
    return answer