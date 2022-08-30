defense, ignore = map(int,input().split())

if defense - (defense * (ignore/100)) >= 100:
    print(0)
else:
    print(1)