def solution(num, k):
    if str(k) in str(num):
        return (str(num).index(str(k))) + 1 #index는 0부터 시작하기 때문에 +1
    else:
        return -1
