N, K = map(int,input().split())
num = list(input()) # 4177252841
stack = []
count = K
for i in num: # 4,1,7,7,2,5.....
    while count > 0 and stack and stack[-1] < i: # count가 소진되지 않고 stack이 존재하며 stack의 이전에 넣은 수가 지금 수보다 작은 경우에만 삭제를 한다. 
        # 4,1,7 경우에 [4,1]과 7은 while문의 조건에 모두 부합하므로 계속 두번 반복되어서 4,1이 모두 삭제된다.
        stack.pop() # 삭제
        count -= 1 # 카운트 차감
    stack.append(i)
    
print(''.join(stack[:N-K])) # 4321과 같은 내림차순이고 K가 2일 경우 43출력해야하기 때문에 stack[:N-K] 해야함