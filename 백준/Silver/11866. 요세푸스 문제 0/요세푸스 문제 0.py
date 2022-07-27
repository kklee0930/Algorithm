from collections import deque
N,K = map(int,input().split())
dq = deque()
result = []

for i in range(1,N+1): #1,2,3,4,5,6,7
    dq.append(i)
    
while dq:
    for i in range(K-1): 
        dq.append(dq.popleft()) 
    result.append(dq.popleft())
    
print('<', end='')
a = ', '.join(map(str, result))
print(a + '>')