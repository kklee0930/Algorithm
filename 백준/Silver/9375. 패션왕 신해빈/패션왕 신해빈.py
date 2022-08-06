for _ in range(int(input())): # 2
    dict = {}
    n = int(input()) # 3
    
    for i in range(n):
        name, item = input().split()
        if item not in dict:
            dict[item] = 1
        else:
            dict[item] += 1
            
    result = 1

    for k in dict.keys(): # headgear, eyewear
        result *= (dict[k]+1) # (의상종류 1에서 선택 가능한 수 + 1) * (2에서 가능한 수 + 1) * ...
            
    print(result - 1) # 알몸인 경우 때문에 -1