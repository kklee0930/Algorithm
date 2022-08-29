x,y,w,h = map(int, input().split())

print(min(x-0, abs(x-w), y-0, abs(y-h)))