def solution(before, after):
    after = list(after)
    for i in before:
        try:
            after.remove(i)
        except:
            return 0
    if after == []:
        return 1