def solution(n):
    result = []
    
    # 2진수 변환시 1의 갯수 같은 숫자중 가장 작은 수
    def Get_binary(num):
        while num != 0:
            if num % 2 == 0:
                result.insert(0, '0')
            elif num % 2 == 1:
                result.insert(0, '1')
            num = num // 2
            
        binary_cnt = ''.join(result).count('1')
        return binary_cnt
    
    cnt = Get_binary(n)

    for num in range(n+1, 1000001):
        result = []
        if cnt == Get_binary(num):
            return num
        