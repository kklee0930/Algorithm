def solution(s):
    answer = 0
    temp_list = s.split()
    for i in range(len(temp_list)):
        if temp_list[i] == 'Z':
            answer -= int(temp_list[i-1])
        else:
            answer += int(temp_list[i])
    return answer