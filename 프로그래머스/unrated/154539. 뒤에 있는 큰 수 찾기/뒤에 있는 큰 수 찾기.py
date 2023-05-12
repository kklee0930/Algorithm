def solution(numbers):
    answer = [-1] * len(numbers)
    stack = [] # 지나간 인덱스를 저장하는 배열
    for i, n in enumerate(numbers): # 0,2 / 1,3 / 2,3 ...
        # numbers[stack[-1]]가 현재 수보다 작을 경우 (이전의 수가 현재의 수보다 작으면 현재 수가 뒷 큰수가 됨)
        while stack and numbers[stack[-1]] < n:
            answer[stack.pop()] = n # answer의 stack[-1]인덱스 자리에 현재 수 추가
        stack.append(i) # 스택에는 현재 인덱스 추가
    return answer