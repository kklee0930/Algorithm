for _ in range(int(input())):
    n, m = map(int, input().split())
    queue = list(map(int, input().split()))
    target = queue[m]
    
    checker = [0 for _ in range(n)]
    checker[m] = 1
    
    count = 0
    
    while True:
        if queue[0] == max(queue):
            count += 1
            if checker[0] == 1:
                print(count)
                break
            else:
                del queue[0]
                del checker[0]
        else:
            queue.append(queue[0])
            del(queue[0])
            checker.append(checker[0])
            del(checker[0])