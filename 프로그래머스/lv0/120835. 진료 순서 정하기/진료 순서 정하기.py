def solution(emergency):
    temp = sorted(emergency, reverse=True)
    answer = []
    for patient in emergency:
        answer.append(temp.index(patient) + 1)
    return answer