def solution(numlist, n):
    temp_list = []
    for num in numlist:
        temp_list.append([abs(num - n), num]) #[[num, 절댓값], [num, 절댓값]...]
    temp_list.sort() #절댓값 기준으로 정렬
    for i in range(len(temp_list)-1):
        if temp_list[i][0] == temp_list[i+1][0]: #절댓값이 같으면
            temp_list[i], temp_list[i+1] = temp_list[i+1], temp_list[i] #서로 위치 변경해주기
    answer = [j[1] for j in temp_list]
    return answer