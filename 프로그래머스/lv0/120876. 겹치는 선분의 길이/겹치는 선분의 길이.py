def solution(lines):
    answer = 0
    list_ = [0] * 201 # -100 ~ 100
    
    for i in range(lines[0][0], lines[0][1]):
        list_[i+100] += 1 # list[100]이 숫자 0을 뜻함
    for i in range(lines[1][0], lines[1][1]):
        list_[i+100] += 1
    for i in range(lines[2][0], lines[2][1]):
        list_[i+100] += 1
        
    answer += list_.count(2)
    answer += list_.count(3)
    return answer

# Test Case 3, 7 에러 (미해결)
#     answer = 0
#     temp = []

#     for line in lines: # 선분이 지나가는 지점을 모두 list에 append
#         for pnt in range(line[0], line[1] + 1):
#             temp.append(pnt)
            
#     li = [] # [겹치는 점1, 겹치는 점2, 겹치는 점3...]
#     for num in range(min(temp), max(temp) + 1):
#         # 겹치면 list append
#         if temp.count(num) >= 2:
#             li.append(num)
#         # 겹치는 부분이 없으면 answer에 반영
#         elif temp.count(num) < 2 and len(li) != 0:
#             answer += len(li) - 1
#             li = []

#     if len(li) != 0:
#         answer += len(li) - 1

            
#     return answer