def solution(s):
    # number of binary trans, num of zeroes removed
    def Get_binary(n, result): # get binary number
        while n != 0:
            if n % 2 == 0:
                n = n // 2
                result.insert(0, '0')
            elif n % 2 == 1:
                n = n // 2
                result.insert(0, '1')
        return ''.join(result)
            
    cnt_zero = 0 # num of zeroes removed
    cnt_binary = 0
    
    while s != '1':
        cnt_zero += s.count('0')
        s = s.replace('0', '') # remove 0
        s = Get_binary(len(s), [])
        cnt_binary += 1
        
    answer = [cnt_binary, cnt_zero]
    return answer