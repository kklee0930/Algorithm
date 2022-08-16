zero_cnt = [1,0,1]
one_cnt = [0,1,1]

def Fibonacci(num):
    length = len(zero_cnt)
    if num >= length:
        for i in range(length, num+1):
            zero_cnt.append(zero_cnt[i-1] + zero_cnt[i-2])
            one_cnt.append(one_cnt[i-1] + one_cnt[i-2])
    print(f'{zero_cnt[num]} {one_cnt[num]}')
    
T = int(input())
for i in range(T):
    num = int(input())
    Fibonacci(num)