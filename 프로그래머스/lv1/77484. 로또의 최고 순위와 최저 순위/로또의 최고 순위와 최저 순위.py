def solution(lottos, win_nums):
    answer = []
    score = 0
    rank_dict = {6: 1, 5: 2, 4: 3, 3: 4, 2: 5, 1: 6, 0: 6} # {점수: 등수}
    
    for num in lottos:
        if num in win_nums: # 당첨된 번호가 있으면 삭제, 등수 추가
            score += 1
            win_nums.remove(num)
    
    answer.append(rank_dict[score + lottos.count(0)]) # 최고등수(기존점수 + 알아볼 수 없는 숫자를 모두 맞춘 점수)
    answer.append(rank_dict[score]) # 최저등수(기존점수 + 알아볼 수 없는 숫자를 하나도 못 맞춘 점수)
    return answer