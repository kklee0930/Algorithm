def solution(numbers):
    answer = []
    num_dict = {'one':1, 'two':2, 'three':3, 'four':4, 'five':5, 'six':6, 'seven':7, 'eight':8, 'nine':9, 'zero':0}
    temp = ''
    for i in numbers:
        temp += i
        if temp in num_dict.keys():
            answer.append(num_dict[temp])
            temp = ''
    return int(''.join(map(str, answer)))