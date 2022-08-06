stack = []
count = 0 #총 막대기의 갯수(잘려서 생성된)
paren = input() # 괄호 input
for i in range(len(paren)):
    if paren[i] == '(': # ( 이면 일단 stack에 push
        stack.append(paren[i])
    else: # ) 이면
        if paren[i-1] == '(': # paren input이 ()이면 레이저
            stack.pop() # 스택 마지막 원소인 ( 제거
            count += len(stack) # 레이저가 지나가면 스택의 ( 갯수만큼 새로운 막대기 생성
        else:
            stack.pop() # ) 일 경우
            count += 1 # ) 는 막대기를 뜻하므로 막대기 += 1
            
print(count)
    