def solution(s):
    answer = []
    
    s = s[2:-2].replace('{', '').replace(',',' ').split('}')
    s = [i.split() for i in s]
    
    s.sort(key=lambda x:len(x))

    for li in s:
        for num in answer:
            li.remove(num)
        answer.append(li[0])
    
    answer = list(map(int, answer))
    return answer