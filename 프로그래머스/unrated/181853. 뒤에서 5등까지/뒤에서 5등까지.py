def solution(num_list):
    answer = []
    num_list.sort(reverse=True)
    for _ in range(5):
        answer.append(num_list.pop())
    return answer