def solution(players, callings):
    dic = {player: i for i, player in enumerate(players)}
    idx_dic = {i: player for i, player in enumerate(players)}

    for call in callings:
        cur_idx = dic[call] # 호명된 선수의 인덱스
        prev_idx = cur_idx-1 # 앞서가는 선수의 인덱스
        prev_name = idx_dic[prev_idx] # 앞서가는 선수의 이름
        
        dic[call] -= 1 
        dic[prev_name] += 1
        
        idx_dic[prev_idx], idx_dic[cur_idx] = call, prev_name
        
    answer = [v for v in idx_dic.values()]
    return answer