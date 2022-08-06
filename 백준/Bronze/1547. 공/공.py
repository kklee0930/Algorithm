lst = [1,2,3]
for _ in range(int(input())):
    x,y = map(int,input().split())
    x_idx = lst.index(x)
    y_idx = lst.index(y)
    lst[x_idx] = y
    lst[y_idx] = x
print(lst[0])