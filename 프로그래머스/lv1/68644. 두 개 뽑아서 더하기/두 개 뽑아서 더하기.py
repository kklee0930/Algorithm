def solution(numbers):
    answer = []
    answer_set = set()
    for i in numbers:
        for j in numbers[numbers.index(i)+1:]:
            answer_set.add(i+j)
    answer = list(answer_set)
    answer.sort()
    return answer