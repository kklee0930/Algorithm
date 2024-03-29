from sys import stdin
import heapq
heap = []

for _ in range(int(stdin.readline())):
    n = int(stdin.readline())
    if n == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap, n)