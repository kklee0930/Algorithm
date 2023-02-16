def solution(sides):
    max_side = max(sides)
    sides.remove(max_side)
    if max_side < sum(sides):
        return 1
    else:
        return 2