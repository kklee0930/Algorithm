def solution(money):
    answer = []
    price = 5500
    for i in range(1, 1001):
        if i * price > money:
            return [i-1, money - (i - 1) * price]