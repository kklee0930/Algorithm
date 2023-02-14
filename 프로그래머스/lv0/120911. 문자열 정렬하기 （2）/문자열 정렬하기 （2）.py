def solution(my_string):
    my_string = my_string.upper() #BCAD
    answer = []
    answer_ = []
    for i in my_string: #BCAD
        answer.append(ord(i)) #B = num
    answer.sort()
    for j in answer: #[num,num,num]
        answer_.append(chr(j))

    answer = ''.join(map(str,answer_)).lower()
    return answer