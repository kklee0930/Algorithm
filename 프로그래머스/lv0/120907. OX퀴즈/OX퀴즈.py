def solution(quiz):
    answer = []
    for prob in quiz:
        equation = prob.split() #[3,-,4,=,-3]
        
        if equation[1] == '-':
            if int(equation[0]) - int(equation[2]) == int(equation[4]):
                answer.append('O')
            else:
                answer.append('X')
                
        elif equation[1] == '+':
            if int(equation[0]) + int(equation[2]) == int(equation[4]):
                answer.append('O')
            else:
                answer.append('X')
                
    return answer