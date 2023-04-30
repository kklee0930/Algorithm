def solution(my_string, queries):
    li = [my_string]
    for q in queries:
        curr = li.pop()
        temp = ''
        res = ''
        for i in range(len(curr)):
            if i in range(q[0], q[1]):
                temp += curr[i]
            elif i == q[1]:
                temp += curr[i]
                temp = temp[::-1]
                res += temp
            else:
                res += curr[i]
        li.append(res)
    return li.pop()