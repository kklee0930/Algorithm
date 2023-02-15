def solution(my_string): # "1 + 2 + 3 - 4"
    temp_list = my_string.split(' ') # ["1","+","2","+","3","-","4"]
    answer = int(temp_list[0]) # answer = 1
    for i in range(1, len(temp_list) - 1, 2): # +부터 한칸식 건너뛰면서 iteration
        if temp_list[i] == '+':
            answer += int(temp_list[i+1]) # 1 + 2
        elif temp_list[i] == '-':
            answer -= int(temp_list[i+1]) # 3 - 4
    return answer