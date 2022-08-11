for _ in range(3):
    count = 0
    answer = []
    
    n = input()
    current_num = n[0]
    
    for i in n:
        # print(current_num)
        if current_num == i:
            count += 1
        elif current_num != i:
            answer.append(int(count))
            current_num = i
            count = 1
            
    answer.append(int(count))
    
    print(max(answer))