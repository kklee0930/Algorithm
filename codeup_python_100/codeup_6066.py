'''3개의 정수(a, b, c)가 입력되었을 때, 짝(even)/홀(odd)을 출력해보자.'''

a,b,c = input().split()
a = int(a)
b = int(b)
c = int(c)
def even_odd(k):
    if k % 2 == 0:
        print('even')
    else:
        print('odd')
    
even_odd(a)
even_odd(b)
even_odd(c)