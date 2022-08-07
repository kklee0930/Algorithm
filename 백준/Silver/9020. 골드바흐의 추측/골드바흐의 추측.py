def Prime(num): # 소수 판별기
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True


for _ in range(int(input())):
    num = int(input())
    a,b = num // 2, num // 2
    while a > 0:
        if Prime(a) == False or Prime(b) == False:
            a -= 1
            b += 1
        elif Prime(a) == True or Prime(b) == True:
            print(a, b)
            break