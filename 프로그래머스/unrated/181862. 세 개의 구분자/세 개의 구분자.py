def solution(myStr):
    myStr = myStr.replace('a', ' ').replace('b', ' ').replace('c',' ')
    answer = myStr.split()
    if answer == []:
        return ['EMPTY']
    else:
        return answer