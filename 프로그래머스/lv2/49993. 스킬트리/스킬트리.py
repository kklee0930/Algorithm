def solution(skill, skill_trees):
    trees = []
    answer = 0
    
    for str_ in skill_trees: # 'BACDE', 'CBADF'...
        temp = ''
        for c in str_:
            if c not in skill: # skill과 관련없는 문자들은 제외처리 (예: A,E,F)
                continue
            temp += c # 관련있는 문자만 temp에 추가 후 trees에 추가
        trees.append(temp)

    for t in trees: # skill과 관련있는 문자만 모은 trees 리스트 순회
        for i in range(len(t)): 
            if t[i] != skill[i]: # 각각 case를 순회하며 skill의 문자 순서와 맞지 않으면 어긋난 것으로 처리
                break
        else:
            answer += 1
        
    return answer