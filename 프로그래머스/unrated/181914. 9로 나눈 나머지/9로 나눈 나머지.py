def solution(number):
    answer = 0
    for n in number:
        answer += int(n)
    if answer % 9 == int(number) % 9:
        return answer % 9