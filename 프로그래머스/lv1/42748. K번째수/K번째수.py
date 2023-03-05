def solution(array, commands):
    answer = []
    for l in commands:
        arr = array[l[0]-1 : l[1]]
        arr.sort()
        answer.append(arr[l[2]-1])
    return answer