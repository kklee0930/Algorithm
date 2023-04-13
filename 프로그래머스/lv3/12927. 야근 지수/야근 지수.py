import heapq
def solution(n, works):
    max_heap = []
    
    for work in works: # 최대힙 구현
        heapq.heappush(max_heap, (-work, work))
    for _ in range(n):
        max_ = heapq.heappop(max_heap) # 최대값 제거하고
        heapq.heappush(max_heap, (max_[0]+1, max_[1]-1)) # 최대값-1 값을 힙에 추가
    
    answer = 0
    for n in max_heap:
        if n[1] < 1:
            continue
        answer += n[1]**2
    return answer