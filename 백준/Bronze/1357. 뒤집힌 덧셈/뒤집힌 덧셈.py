def Rev(x, y):
    c = str(a+b)
    c = int(c[::-1])
    return c
    
a,b = map(str,input().split())
a  = int(a[::-1])
b = int(b[::-1])

print(Rev(a,b))