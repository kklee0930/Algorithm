while True:
    N = int(input())
    if N == 0:
        break
    R = str(N)[::-1]

    if str(N) == str(R):
        print('yes')
    else:
        print('no')