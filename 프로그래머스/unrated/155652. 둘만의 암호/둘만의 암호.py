def solution(s, skip, index):
    answer = ''
    skip_list = []
    
    # ord('a') = 97, ord('z') = 122
    for skipped in skip:
        skip_list.append(ord(skipped)) # 숫자로 변환해서 리스트에 추가
    
    for str_ in s:
        ord_ = ord(str_) # 숫자로 변환
        for _ in range(index): # 인덱스만큼 바꿔주기
            ord_ += 1
            if ord_ > 122: # 122(z) 넘어가면 97(a)로 돌아감
                ord_ = 97
            while ord_ in skip_list: # 변환한 숫자가 skip리스트에 존재하면 건너뜀
                ord_ += 1
                if ord_ > 122: # 122(z) 넘어가면 97(a)로 돌아감
                    ord_ = 97
        
        answer += chr(ord_)
        
    return answer