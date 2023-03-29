import heapq
def solution(operations):
    min_heap = []
    max_heap = []
    
    for cmd in operations:
        if cmd[0] == 'I':
            heapq.heappush(min_heap, int(cmd[2:]))
            heapq.heappush(max_heap, (-int(cmd[2:]), int(cmd[2:])))
                           
        elif cmd == 'D 1' and max_heap: # 최대힙삭제
            max_ = heapq.heappop(max_heap)
            min_heap.remove(max_[1])
            heapq.heapify(min_heap)
                    
        elif cmd == 'D -1' and min_heap: # 최소힙삭제
            min_ = heapq.heappop(min_heap)
            max_heap.remove((-min_, min_))
            heapq.heapify(max_heap)
    
    if min_heap or max_heap:
        min_ = heapq.heappop(min_heap)
        max_ = heapq.heappop(max_heap)[1]
        return [max_, min_]
                           
    else:
        return [0, 0]