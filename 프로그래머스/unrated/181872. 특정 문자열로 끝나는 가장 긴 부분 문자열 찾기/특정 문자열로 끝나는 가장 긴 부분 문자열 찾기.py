def solution(myString, pat):
    for i in range(len(myString)-1, -1, -1):
        if myString[i] == pat[-1]:
            if myString[i-len(pat)+1:i+1] == pat:
                return myString[:i+1]