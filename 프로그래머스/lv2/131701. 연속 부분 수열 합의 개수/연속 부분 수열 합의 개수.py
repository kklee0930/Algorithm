def solution(elements):
    answer = 0
    set_ = set([])
    
    for n in range(len(elements)): # 길이만큼 iteration
        for i in range(len(elements)): # 0, 1, 2, 3, 4
            end = i + n # 길이가 2인 경우 elements[0:1], [1:2], [2:3]...
            if end >= len(elements): # 리스트 인덱스를 벗어나는 경우
                end = end % len(elements) # 리스트에서 초과해서 벗어나는 만큼을 구하고
                set_.add(sum(elements[i:] + elements[:end])) # i부터 리스트 끝 + 처음부터 초과인덱스 값 구해서 계산
            else:
                set_.add(sum(elements[i:end]))
    return len(set_)