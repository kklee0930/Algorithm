count = 0
dict = {}

for _ in range(int(input())):
    n = input()
    
    if n == 'ENTER':
        dict = {}
        
    elif n not in dict:
        dict[n] = 1
        count += 1
        
print(count)