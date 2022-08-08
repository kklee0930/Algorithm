for _ in range(int(input())): # Test Case의 갯수
    price = int(input()) # 자동차 기본 가격
    option = int(input()) # Option의 갯수
    
    option_cost = 0 # Option 총 비용
    
    for i in range(option): # Option 갯수만큼 loop
        q,p = map(int,input().split()) # 옵션 갯수와 가격
        option_cost += p*q # 옵션 가격 += 갯수 * 옵션가격
    print(option_cost + price) # 총비용