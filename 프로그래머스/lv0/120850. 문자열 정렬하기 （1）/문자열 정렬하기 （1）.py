def solution(my_string):
    answer = []
    for i in my_string:
        try:
            i = int(i)
            answer.append(i)
        except:
            pass
    answer.sort()
    return answer