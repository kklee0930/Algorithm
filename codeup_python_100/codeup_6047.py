'''정수 2개(a, b)를 입력받아 a를 2b배 곱한 값으로 출력해보자.
0 <= a <= 10, 0 <= b <= 10

예시
a = 2
b = 10
print(a << b)  #210 = 1024 가 출력된다.'''

a, b = input().split()
a = int(a)
b = int(b)
print(a*(2**b))
