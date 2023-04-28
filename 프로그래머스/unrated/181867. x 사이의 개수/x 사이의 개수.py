def solution(myString):
    li = myString.split('x')
    answer = [len(i) for i in li]
    return answer