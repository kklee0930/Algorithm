n = int(input()) # 입력 값
while True:
    success = True # success 변수를 True로 지정
    for i in str(n): # 입력값의 문자열 하나하나를 iteration
        if i != '7' and i != '4': # 문자열이 7이나 4가 아닐 경우
            success  = False # success를 False로 재정의
            n -= 1 # 입력값 -= 1
    if success: # success True인 경우 
        print(n) # 입력값 출력
        break