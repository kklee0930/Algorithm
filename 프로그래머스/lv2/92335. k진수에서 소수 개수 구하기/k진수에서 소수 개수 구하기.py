def solution(n, k):
    answer = 0
    
    # k진법의 수로 변환
    li = []
    while n != 0:
        li.append(n % k)
        n = n // k
    k_num = ''
    for _ in range(len(li)):
        k_num += str(li.pop())
    
    # split을 적용한 리스트 중에 1과 ''를 제외한 원소
    split = [elem for elem in k_num.split('0') if elem != '1' if elem != '']
    split = list(map(int, split))
    
    # 시간 단축을 위해 제곱근까지만 소수 판별 iteration실행
    for n in split:
        num = int(n**(0.5)+1)
        for i in range(2, num):
            if n % i == 0:
                break
        else:
            answer += 1
        
    return answer