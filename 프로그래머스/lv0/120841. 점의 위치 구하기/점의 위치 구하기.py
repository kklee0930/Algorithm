def solution(dot):
    if dot[0] * dot[1] < 0: # 2, 4사분면
        if dot[0] < 0: # 2사분면
            return 2
        else: # 4사분면
            return 4
    else: # 1, 3사분면
        if dot[0] < 0: # 3사분면
            return 3
        else: # 1사분면
            return 1 