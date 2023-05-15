def solution(routes):
    answer = 1
    min_ = 30000
    routes.sort(key=lambda x: x[0])
    for i, j in routes: # i가 최소영역을 한 번 벗어날 때마다 필요한 카메라의 갯수가 1개씩 증가함
        if i > min_:
            answer += 1
            min_ = j
        min_ = min(min_, j)
    return answer