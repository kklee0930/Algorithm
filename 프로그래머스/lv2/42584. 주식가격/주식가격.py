from collections import deque
def solution(prices):
    answer = []
    prices = deque(prices)
    while prices:
        cnt = 0
        start = prices.popleft() # 비교대상이 되는 시작가 (1,2,3,2,3)
        for i in prices: # 시작가 이후 변화하는 값 i
            cnt += 1 # 초
            if start > i:
                break
        answer.append(cnt)
    return answer
