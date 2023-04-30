def solution(rank, attendance):
    answer = []
    for i in range(len(rank)):
        if attendance[i] == False:
            rank[i] = 999
    for _ in range(3):
        idx = rank.index(min(rank))
        answer.append(idx)
        rank[idx] = 999
        
    return 10000 * answer[0] + 100 * answer[1] + answer[2]