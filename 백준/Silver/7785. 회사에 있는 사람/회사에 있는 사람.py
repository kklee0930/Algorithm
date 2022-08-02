from sys import stdin
dict = {}
n = int(stdin.readline())

for _ in range(n):
    # 직원 이름과 enter / leave 여부 딕셔너리에 저장
    a,b = stdin.readline().split()
    dict[a] = b

result = []

for i in dict:
    # 딕셔너리 value == enter인 것만 리스트에 삽입(아직 퇴근 안했다는 뜻)
    if dict[i] == 'enter':
        result.append(i)

# 역순으로 출력
result.sort(reverse=True)

for j in result:
    print(j)