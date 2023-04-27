def solution(myString, pat):
    answer = 0
    myString = myString.replace('A', 'b').replace('B', 'A').upper()
    if pat in myString:
        return 1
    else:
        return 0