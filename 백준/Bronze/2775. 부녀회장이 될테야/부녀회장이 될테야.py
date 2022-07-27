for i in range(int(input())):
    k = int(input()) # 층
    n = int(input()) # 호
    
    base = [x for x in range(1, n+1)] # 0층
    for floor in range(k): # [0,1]
        for room in range(1,n): # [1,2]
            base[room] += base[room-1] 
        # print(base)
    print(base[-1])