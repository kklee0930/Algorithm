def solution(nums):
    poke_dict = {}
    for num in nums:
        if len(poke_dict) >= len(nums) / 2: # 해시 크기를 N/2 로 제한
            break
        if num not in poke_dict: # 폰켓몬에 해시에 없을 때에 추가
            poke_dict[num] = 1
        else:
            pass
        
    answer = len(poke_dict)
    return answer