def solution(score):
    avg = []
    answer = []
    for data in score:
        # 평균 구해서 avg에 넣기
        avg_score = (data[0] + data[1]) / 2
        avg.append([avg_score]) 
    # 내림차순으로 정렬한 avg를 sorted_list로 선언
    sorted_list = sorted(avg, reverse=True)
    # 기존 avg를 순회하며 i를 정렬된 sorted_list에서 인덱스로 검색
    for i in avg:
        answer.append(sorted_list.index(i) + 1)
    return answer