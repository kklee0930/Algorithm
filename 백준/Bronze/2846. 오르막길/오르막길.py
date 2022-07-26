N = int(input())
Pi = map(int, input().split()) # [1,2,1,4,6]
test_list = []
result_list = []
for i in Pi:
    if test_list == []: # 시작할 때 리스트가 비어 있으면 리스트에 원소를 추가 [1]
        test_list.append(i)
    if test_list[-1] < i: # i가 리스트의 마지막 원소보다 큰 경우에만 원소 추가 [1,2]
        test_list.append(i)
    elif test_list[-1] >= i: # i가 리스트 마지막 원소와 같거나 작은 경우
        result = test_list[-1] - test_list[0] # 오르막 값 계산
        result_list.append(result) 
        test_list = [i] # 리스트 재정의
        
result = test_list[-1] - test_list[0]
result_list.append(result)

print(max(result_list))