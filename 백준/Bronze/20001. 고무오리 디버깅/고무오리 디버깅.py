stack = []

while True:
    n = input()
            
    if n == '문제':
        stack.append(1)
        
    elif n == '고무오리':
        if len(stack) == 0:
            stack.extend([1,1])

        else:
            stack.pop()
            
    elif n == '고무오리 디버깅 끝':
        break
    
if len(stack) == 0:
    print('고무오리야 사랑해')
else:
    print('힝구')