'''3개의 정수(a, b, c)가 입력되었을 때, 짝수만 출력해보자.
'''
a,b,c = input().split()
a = int(a)
if a % 2 == 0:
    print(a)

b = int(b)
if b % 2 == 0:
    print(b)
    
c = int(c)
if c % 2 == 0:
    print(c)