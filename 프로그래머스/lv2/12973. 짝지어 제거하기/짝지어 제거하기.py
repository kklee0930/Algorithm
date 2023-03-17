def solution(s):
    stack = []
    for char in s:
        stack.append(char)
        # stack 길이가 2미만이 되거나 두 끝 원소가 달라질 때까지 pop한다
        while (len(stack) >= 2) and (stack[-1] == stack[-2]):
            stack.pop()
            stack.pop()
                
    if stack == []:
        return 1
    return 0
