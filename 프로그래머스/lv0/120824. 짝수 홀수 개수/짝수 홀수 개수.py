def solution(num_list):
    odds = 0
    evens = 0
    for i in num_list:
        if i % 2 == 0:
            evens += 1
        else:
            odds += 1
    return [evens, odds]