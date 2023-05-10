def solution(files):
    result = []
    for file in files:
        head, num, tail = "", "", ""
        i = 0
        while i < len(file):
            while i < len(file): # head에 해당하는 문자를 뽑아내는 단계
                if head and file[i].isnumeric() == True:
                    break
                head += file[i]
                i += 1
            while i < len(file): # number에 해당하는 문자를 뽑아내는 단계
                if num and file[i].isnumeric() == False:
                    break
                num += file[i]
                i += 1
            while i < len(file):
                tail += file[i] # tail에 해당하는 문자를 뽑아내는 단계
                i += 1

        result.append([head, num, tail])
        
        # 1. head기준 사전 순, 대소문자 구분 X
        # 2. 숫자 순 정렬 (head와 number이 같을 경우 정렬하지 않기 때문에 3번째 조건은 X)
        result.sort(key=lambda x: (x[0].lower(), int(x[1])))
        answer = [''.join(li) for li in result]
    return answer