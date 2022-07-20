C = int(input())
for test_case in range(1, C+1):
    n = list(map(int, input().split())) # test case를 리스트로 생성
    n = n[1::] # 학생의 수 제외
    average = sum(n) / len(n)
    
    excellent = []
    for i in n:
        if i > average:
            excellent.append(i)
    print(f'{len(excellent)/len(n) * 100:.3f}%')