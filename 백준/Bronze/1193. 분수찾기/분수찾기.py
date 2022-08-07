num = int(input()) 

line = 1
while num > line: 
    num -= line 
    line += 1 

if line % 2 == 0: # 짝수일 경우 앞에서
    a = num 
    b = line - num + 1
    
else: # 홀수일 경우 뒤에서
    a = line - num + 1
    b = num
    
print(f'{a}/{b}')