def solution(array): # [1, 2, 3, 3, 3, 4]
    temp_list = sorted(set(array)) # [1, 2, 3, 4]
    count_list = []
    for num in temp_list:
        count_list.append(array.count(num)) # 원소 갯수를 같은 index에 삽입
    max_cnt = max(count_list)
    if count_list.count(max_cnt) > 1: # 최빈값이 여러개
        return -1
    else:
        return temp_list[count_list.index(max_cnt)]