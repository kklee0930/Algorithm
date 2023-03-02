def solution(s):
    list_ = s.split(' ')
    temp2 = []
    
    for word in list_:
        temp1 = []
        for i in range(len(word)):
            if i % 2 == 0:
                temp1.append(word[i].upper())
            else:
                temp1.append(word[i].lower())
        combined = ''.join(temp1)
        temp2.append(combined)
        
    answer = ' '.join(temp2)
    return answer
    