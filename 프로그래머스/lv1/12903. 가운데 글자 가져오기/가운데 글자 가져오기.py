def solution(s):
    # -1은 인덱스는 0부터 시작하기 때문
    if len(s) % 2 != 0: #홀수일 경우
        answer = s[int((len(s) + 1) / 2 - 1)]
        return answer
    else: #짝수일 경우
        answer1 = s[int(len(s) / 2 - 1)]
        answer2 = s[int((len(s) / 2) + 1 - 1)]
        return answer1 + answer2