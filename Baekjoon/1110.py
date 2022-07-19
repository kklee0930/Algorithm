n = input()
count = 0


if n < 10:
    add_zero = '0' + str(n)
    result = int(add_zero)
    result = str(n)[1] + str(result)[1]
    count += 1
    
elif n >= 10:
    result = str(n)[0] + str(n)[1]
    result = str(n)[1] + str(sum)[1]
    count += 1

elif result < 10:
    add_zero = '0' + str(n)
    sum = str(n)[0] + str(n)[1]
    result = str(n)[1] + str(sum)[1]
    count += 1
    
elif result >= 10:
    add_zero = '0' + str(n)
    sum = str(n)[0] + str(n)[1]
    result = str(n)[1] + str(sum)[1]
    count += 1
    
elif sum == n:
    print(count)
    break