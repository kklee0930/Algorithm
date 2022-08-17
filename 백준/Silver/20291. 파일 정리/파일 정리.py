dict = {}
for _ in range(int(input())):
    file = input().split('.')
    if file[1] not in dict:
        dict[file[1]] = [file[0]]
    else:
        dict[file[1]].append(file[0])

sorted_key = sorted(dict.keys())
for key in sorted_key:
    print(key, len(dict[key]))