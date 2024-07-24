import sys

input = sys.stdin.readline

# -를 기준으로 나눈다음
arr = input().split("-")
result = 0

# 첫 번째 나눈값을 모두 더하고
for num in arr[0].split("+"):
    result += int(num)
    
# 나머지 값들을 모두 뺀다
for i in arr[1:]:
    for j in i.split("+"):
        result -= int(j)

print(result)