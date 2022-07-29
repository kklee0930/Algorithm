T = int(input())
lst = []
for i in range(1, T+1):
    a,b = map(int, input().split())
    lst.append([b,a])
    
lst.sort()

for b,a in lst:
    print(a,b)