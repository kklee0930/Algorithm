'''문자 1개를 입력받아 그 다음 문자를 출력해보자.
영문자 'A'의 다음 문자는 'B'이고, 숫자 '0'의 다음 문자는 '1'이다.

예시
...
print(chr(n+1))'''

a = int(input())
print(ord(a + 1))