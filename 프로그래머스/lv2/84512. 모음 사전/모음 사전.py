def solution(word):
    answer = 0
    # 6진법을 이용한 풀이
    char = ["A", "E", "I", "O", "U"]
    li = [781, 156, 31, 6, 1] # 각 자릿수별 필요한 연산 횟수
    for i in range(len(word)):
        answer += (char.index(word[i])) * li[i] # 알파벳 인덱스 * 자릿수 연산횟수
    answer += len(word) # word 길이
    return answer