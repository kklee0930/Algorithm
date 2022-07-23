T = int(input())
for number in range(T+1):
    my_list = []
    my_list.extend(str(number))
    my_list = map(int,my_list)
    if number + sum(my_list) == T:
        print(number)
        break
    elif number == T:
        print(0)