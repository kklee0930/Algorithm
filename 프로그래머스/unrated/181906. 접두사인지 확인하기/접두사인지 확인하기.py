def solution(my_string, is_prefix):
    for i in range(len(my_string)):
        if my_string[0:i] == is_prefix:
            return 1
    else:  
        return 0