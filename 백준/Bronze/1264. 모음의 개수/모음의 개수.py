while True:
    s = input()
    if s == '#':
        break
    
    count = 0

    for i in s:
        if i in 'aeiouAEIOU':
            count += 1
            
    print(count)