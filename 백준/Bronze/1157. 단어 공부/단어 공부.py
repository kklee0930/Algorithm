A = input().lower()
my_dict = {}
my_list = []

for i in A:
    if i not in my_dict:
        my_dict[i] = 1
    else:
        my_dict[i] += 1
max_value = max(list(my_dict.values()))

for k,v in my_dict.items(): 
    if v == max(my_dict.values()): 
        my_list.append(k)

if len(my_list) > 1:
    print('?')
else:
    print(my_list[0].upper())