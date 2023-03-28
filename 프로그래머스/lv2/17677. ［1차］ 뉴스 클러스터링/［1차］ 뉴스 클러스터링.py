def solution(str1, str2):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    dict1 = {}
    dict2 = {}
    
    # 두 문자열씩 끊기 위해서는 전체 문자열길이-1을 범위로 잡아야함. 인덱스 F:0, R:1 ... C: len(str)-1
    for i in range(len(str1)-1): 
        str_ = (str1[i] + str1[i+1]).lower()
        # 알파벳이 아니면 버리고 건너뛰기
        if (str_[0] not in alphabet) or ((str_[1] not in alphabet)):
            continue
        # 해시에 값을 저장
        if str_ not in dict1:
            dict1[str_] = 1
        else:
            dict1[str_] += 1
            
    # 같은 방식으로 반복
    for j in range(len(str2)-1):
        str_ = (str2[j] + str2[j+1]).lower()
        if (str_[0] not in alphabet) or ((str_[1] not in alphabet)):
            continue
        if str_ not in dict2:
            dict2[str_] = 1
        else:
            dict2[str_] += 1
            
    intersect = 0 # 교집합
    union = 0 # 공집합
    for k, v1 in dict1.items():
        if k in dict2: # 해시 키값이 두 문자열에 모두 존재하면
            intersect += (min(v1, dict2[k])) # 교집합은 min(a,b)
            union += (max(v1, dict2[k])) # 공집합은 max(a,b)
        else:
            union += v1 # str2에 존재하지 않으면 str1의 값이 공집합의 원소가 됨
            
    for k, v2 in dict2.items():
        if k not in dict1:
            union += v2
            
    try: 
        J = int(intersect / union * 65536)
    except: # 공집합인 경우에는 1로 정의
        J = 1 * 65536
        
    return J