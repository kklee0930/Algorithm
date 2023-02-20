def solution(my_string):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    for i in range(len(my_string)):
        try:
            int(my_string[i])
        except:
            my_string = my_string.replace(my_string[i], ' ')
    answer = sum(map(int, my_string.split()))
    return answer