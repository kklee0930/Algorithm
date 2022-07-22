while True:
    my_list = list(map(int, input().split()))
    if sum(my_list) == 0:
        break
    
    my_list.sort()
    
    if my_list[0]**2 + my_list[1]**2 == max(my_list)**2:
        print('right')
        
    if my_list[0]**2 + my_list[1]**2 != max(my_list)**2:
        print('wrong')