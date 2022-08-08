n = int(input()) # 반의 수
for i in range(1, n+1): # 반의 수 만큼 iteration
    lst = list(map(int,input().split())) # split해서 리스트로 반환받음
    lst = lst[1::] # 앞의 숫자는 학생수이므로 제거
    lst = sorted(lst, reverse=True) # 리스트를 내림차순으로 정렬
    
    # 가장 큰 인접한 점수 차이 구하기
    max_gap = 0 # 가장 큰 점수 차이 초기화
    for j in range(len(lst)-1): # 0부터 전체길이-1까지 for 문
        gap = abs(lst[j] - lst[j+1]) # 인접한 점수 차이 = 첫번째 원소 - 두번째 원소
        if gap > max_gap: # 현재 점수차이가 가장 큰 점수차이보다 크면
            max_gap = gap # 가장 큰 점수차이 = 현재 점수차이
    
    max_ = max(lst) # 리스트의 max
    min_ = min(lst) # 리스트의 min

    print(f'Class {i}')
    print(f'Max {max_}, Min {min_}, Largest gap {max_gap}')
