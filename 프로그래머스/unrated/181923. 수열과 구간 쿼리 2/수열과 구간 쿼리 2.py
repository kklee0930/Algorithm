def solution(arr, queries):
    answer = []
    for q in queries:
        arr_ = arr[q[0]:q[1]+1]
        res = [i for i in arr_ if i > q[2]]
        if res == []:
            answer.append(-1)
        else:
            answer.append(min(res))
    return answer