def solution(s):
    answer = []
    for char in s:
        answer.append(ord(char)) #아스키코드 변환해서 append
    answer.sort(reverse=True) #역순으로 sort
    answer = ''.join(list(map(chr, answer))) #아스키코드를 문자열로 재변환 후 str형태로 join
    return answer