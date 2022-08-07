stack = []
result = []
fail = False
count = 1

# input만큼 for문을 돌린다.
for _ in range(int(input())):

    # num 숫자를 입력받는다.
    num = int(input())

    # while과 count변수를 활용하여 count부터 num 입력값까지의 수를 넣어준다.
    while count <= num:
        stack.append(count)
        
        #result에는 append시 +를 넣어준다.
        result.append('+')
        count += 1
    
    # stack의 마지막 원소 == num일시 빼준다.
    if stack[-1] == num:
        stack.pop()
        
        # 빼 줌과 동시에 result에 -를 넣어준다.
        result.append('-')

    else:
        # 불가능하면 fail = True 
        fail = True
    
if fail == True:
    print('NO')
else:
    for i in result:
        print(i)