def solution(answers):
    fir = [1,2,3,4,5]
    sec = [2,1,2,3,2,4,2,5]
    thr = [3,3,1,1,2,2,4,4,5,5]
    score = [0,0,0,0]
    
    for i in range(0, len(answers)): # 맞으면 맞은 갯수 추가
        if answers[i] == fir[i % len(fir)]: # index range error 방지 위해여 i % (len(학생))
            score[1] += 1
        if answers[i] == sec[i % len(sec)]:
            score[2] += 1
        if answers[i] == thr[i % len(thr)]:
            score[3] += 1

    max_score = max(score)
    answer = [i for i in range(1, len(score)) if score[i] == max_score] # 최고점과 같을 경우에만 학생 번호 추가
    return answer