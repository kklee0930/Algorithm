import sys

temp = set()
for _ in range(int(sys.stdin.readline())):
    str_ = sys.stdin.readline().strip()
    temp.add(str_)

temp = list(temp)
result = sorted(temp, key = lambda x: (len(x), x))

for li in result:
    print(li)