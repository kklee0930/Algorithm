from itertools import combinations
def solution(nums):
    
    def prime_num(num): # 소수 판별하기
        for i in range(2, num): # 소수가 아니면 0 return
            if num % i == 0:
                return 0
        return 1 #소수면 1 return
    
    # 3가지의 모든 조합중에서 합이 소수인 조합만 선별
    combs = list(filter(lambda x: prime_num(sum(x)) == 1, combinations(nums, 3)))
    answer = len(combs) 

    return answer