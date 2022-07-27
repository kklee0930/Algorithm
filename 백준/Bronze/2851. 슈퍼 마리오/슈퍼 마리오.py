list_ = []

for i in range(10):
    list_.append(int(input()))
    
sum_ = 0

for j in list_:
    sum_ += j
    # print(f'sum_: {sum_}')
    if sum_ == 100:
        print(sum_)
        break
    
    elif sum_ > 100:
        current_sum = abs(sum_ - 100)
        prev_sum = abs(sum_ - 100 - j)
        # print(current_sum, prev_sum)

        if current_sum <= prev_sum:
            print(sum_)
            break
        
        elif current_sum > prev_sum:
            print(sum_ - j)
            break
else:
    if sum_ < 100:
        print(sum_)