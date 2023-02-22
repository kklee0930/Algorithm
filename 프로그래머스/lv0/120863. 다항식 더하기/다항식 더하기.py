def solution(polynomial):
    temp_list = polynomial.split(' + ')

    constant_val = 0
    x_val = 0
        
    for elem in temp_list:
        
        if 'x' in elem:
            elem = elem.strip('x')
            if elem == '':
                elem = 1
            x_val += int(elem)
            
        elif 'x' not in elem:
            constant_val += int(elem)
            
    # x_val = 1 or x_val = 0 or x_val > 1 
    # constant_val = 0 or constant_val > 0
    
    if constant_val == 0:
        if x_val == 1:
            return 'x'
        elif x_val == 0:
            return '0'
        elif x_val > 1:
            return f'{x_val}x'
        
    elif constant_val > 0:
        if x_val == 1:
            return f'x + {constant_val}'
        elif x_val == 0:
            return f'{constant_val}'
        elif x_val > 1:
            return f'{x_val}x + {constant_val}'