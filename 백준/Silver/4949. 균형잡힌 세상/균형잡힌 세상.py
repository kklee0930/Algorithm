while True:
    N = input()
    if N == '.':
        break
    stack = []
    for i in N:
        if i in ['(', '[', ')', ']']:
            stack.append(i)
            if len(stack) >= 2:
                if stack[-2:] == ['(',')'] or stack[-2:] == ['[',']']:
                    stack = stack[:-2]

    if len(stack) == 0:
        print('yes')
    elif len(stack) != 0:
        print('no')