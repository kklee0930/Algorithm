from itertools import permutations
def prime_check(num):
    if num == 2:
        return True
    if num == 1 or num == 0:
        return False
    for i in range(2, num):
        if num % i == 0:
            return False
    else:
        return True
    
def solution(numbers):
    answer = set() # 중복 방지하기 위하여 set 사용
    numbers = list(numbers) # permutation 사용 위해서 list화
    for i in range(1, len(numbers)+1): # 1가지~자릿수가지 순열 찾기 시행
        p = set(permutations(numbers, i))
        for n in p:
            num = int(''.join(n))
            if prime_check(num) == True:
                answer.add(num)
    return len(answer)