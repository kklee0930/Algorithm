for _ in range(int(input())):
    dict = {}
    
    note1_cnt = int(input())
    note1 = list(map(int, input().split()))
    
    for i in note1:
        dict[i] = 1
        
    note2_cnt = int(input())
    note2 = list(map(int, input().split()))
    
    for j in note2:
        if j in dict:
            print(1)
        elif j not in dict:
            print(0)