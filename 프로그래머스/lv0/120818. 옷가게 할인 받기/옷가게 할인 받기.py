def solution(price):
    if 100000 <= price < 300000:
        price *= 0.95
    elif 300000 <= price < 500000:
        price *= 0.90
    elif 500000 <= price:
        price *= 0.80
    return int(price)
    