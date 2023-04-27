def solution(binomial):
    li = binomial.split()
    if li[1] == '+':
        return int(li[0]) + int(li[2])
    elif li[1] == '-':
        return int(li[0]) - int(li[2])
    else:
        return int(li[0]) * int(li[2])