def solution(price, money, count):
    payment = 0
    for i in range(1, count+1):
        payment += price * i
    if payment > money:
        return payment - money
    else:
        return 0