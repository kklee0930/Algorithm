def solution(bin1, bin2):
    # 십진수로 변환
    num1 = int(bin1, 2)
    num2 = int(bin2, 2)
    answer = bin(num1 + num2)[2:]
    return answer