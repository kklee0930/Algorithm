from sys import stdin
# N: 다음 N개의 줄에 집합 S에 포함되어 있는 문자열들이 주어짐
# M: 검사해야하는 문자열들
a,b = map(int, stdin.readline().split())
dict = {}
count = 0

for _ in range(a):
    string_ = str(stdin.readline().strip())
    dict[string_] = 1
    
for _ in range(b):
    check_str = str(stdin.readline().strip())
    if check_str in dict:
        count += 1 
print(count)