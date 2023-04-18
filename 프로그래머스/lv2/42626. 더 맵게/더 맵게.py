import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    
    cnt = 0
    while True:
        min_ = heapq.heappop(scoville) # 가장 맵지 않은 음식의 스코빌 지수
        if min_ >= K: # K 이상이면 중지
            break
        cnt += 1
        min_2 = heapq.heappop(scoville)
        heapq.heappush(scoville, min_ + (min_2*2))
        
        if len(scoville) <= 1 and scoville[0] < K: # 힙에 원소가 하나 남을 경우 더 이상 진행이 불가능하므로 -1
            return -1
    return cnt