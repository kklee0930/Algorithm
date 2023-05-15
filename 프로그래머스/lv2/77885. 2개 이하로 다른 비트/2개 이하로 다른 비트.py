def solution(numbers):
    answer = []
    for num in numbers:
        if num % 2 == 0:
            n = bin(num)[2:-1]
            n += '1'
        else:
            n = list('0' + bin(num)[2:])
            for i in range(len(n)-1, 0, -1):
                if (n[i] == '1' and n[i-1] == '0') or (n[i] == '1' and n[i-1] == '0'):
                    n[i], n[i-1] = n[i-1], n[i]
                    break
        answer.append(int(''.join(n), 2))
        
    return answer
                    