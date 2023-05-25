def solution(number, k):
    answer = []
    for i in number:
        if not answer:
            answer.append(i)
            continue
        while i > answer[-1] and k > 0:
            answer.pop()
            k -= 1
            if not answer or k <= 0: # answer가 비거나 제거한 수가 k를 넘어가면 break
                break
        answer.append(i)
        if len(answer) == len(number)-k:
            break
    return ''.join(answer)