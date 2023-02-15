def solution(n):
    answer = []
    for i in str(n):
        answer.append(i)
    return sum(map(int, answer))