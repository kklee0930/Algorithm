import sys

T = int(input())
s = set()
for tc in range(1, T+1):
    str_input = str(sys.stdin.readline().split())
    s.add(str_input)

sorted_set = sorted(s, key=lambda x: (len(x), x[::]))
for word in sorted_set:
    print(word.strip("['").strip("']"))
