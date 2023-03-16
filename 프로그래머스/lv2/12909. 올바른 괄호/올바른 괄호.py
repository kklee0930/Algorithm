from collections import deque
def solution(s):
    dq = deque(s)
    stack = []
    
    for _ in range(len(dq)):
        stack.append(dq.popleft()) # dq의 왼쪽에서 pop 한것을 stack에 추가
        if len(stack) >= 2: # stack의 길이가 2 이상인 경우에만 조합을 맞출 수 있음
            if stack[-2] + stack[-1] == '()': # 올바르게 짝지어졌으면 삭제
                stack.pop()
                stack.pop()
            elif stack[-2] + stack[-1] == ')(': # 삭제 불가능한 조합이면 false
                return False
            
    if len(stack) > 0: # 올바르게 짝지어진 조합일 경우 stack은 텅비게 됨
        return False
    return True