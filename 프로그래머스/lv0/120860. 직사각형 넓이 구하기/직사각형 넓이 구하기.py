def solution(dots):
    height = 0
    width = 0
    for i in range(len(dots) - 2):
        for j in range(i+1, len(dots) - 1):
            if dots[i][0] == dots[j][0]: # 세로길이
                height = abs(dots[i][1] - dots[j][1])
            elif dots[i][1] == dots[j][1]: # 가로길이
                width = abs(dots[i][0] - dots[j][0])
            if height == True and width == True:
                break
    return width * height
            