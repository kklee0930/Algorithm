def solution(phone_book):
    dict_ = {}
    answer = True
    for num in phone_book: # 원소를 모두 해시에 추가
        dict_[num] = 1
    for key in dict_:
        # 키의 마지막 끝자리-1 index까지 순회하면서 부분 값이 해시에 존재하는지 체크
        for i in range(len(key)):
            if key[:i] in dict_:
                return False
    return answer