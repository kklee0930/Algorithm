import sys
import math

N = int(sys.stdin.readline())

lst = map(int, sys.stdin.readline().strip().split())
cnt = 0

for n in lst:
    if n == 1:
        continue
        
    div = int(math.sqrt(n))
    
    for i in range(2, div + 1):
        if n % i == 0:
            break
    else:
        cnt += 1

print(cnt)