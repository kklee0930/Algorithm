from itertools import combinations
def solution(number):
    # 3가지의 모든 조합 중에 합이 0인 것들을 필터링
    answer = list(filter(lambda e: sum(e) == 0, combinations(number, 3)))
    return len(answer)