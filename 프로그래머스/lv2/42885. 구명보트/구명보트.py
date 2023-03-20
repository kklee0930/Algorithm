def solution(people, limit):
    answer = 0 
    start = 0 # 가장 가벼운 사람의 index
    end = len(people) - 1 # 가장 무거운 사람 index
    
    people = sorted(people)

    # 투포인터 알고리즘
    while start <= end:
        if people[start] + people[end] > limit:
            end -= 1
            answer += 1
        else:
            start += 1
            end -= 1
            answer += 1
    return answer