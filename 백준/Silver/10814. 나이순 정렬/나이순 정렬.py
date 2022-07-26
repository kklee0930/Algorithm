n = int(input())

members_info = []

for i in range(1, n+1):
    age, name = input().split()
    age = int(age)
    members_info.append((age, name)) # 핵심

members_info.sort(key=lambda x: x[0]) # 핵심

for i in members_info:
    print(i[0], i[1])