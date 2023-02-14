def solution(my_str, n):
    answer = []
    while True:
        if len(my_str) >= n: #문자열의 크기가 n보다 크거나 같으면
            answer.append(my_str[:n]) #리스트에 추가할 문자가 있다는 뜻
            my_str = my_str[n:] #문자열 줄여주기
        elif len(my_str) < n: #남은 문자열 길이가 n보다 작으면
            if my_str == '': #남은 문자열 없으면 
                return answer #그대로 리턴
            answer.append(my_str[::]) #아니면 나머지 모두 추가
            return answer