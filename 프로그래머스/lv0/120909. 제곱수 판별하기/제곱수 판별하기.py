def solution(n):
    num = (n)**(1/2)
    if round(num)**2 == n:
        return 1
    else:
        return 2