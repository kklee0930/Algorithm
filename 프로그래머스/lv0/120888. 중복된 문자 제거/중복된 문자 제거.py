def solution(my_string):
    answer = ''
#     dict_ = {}
#     answer = []
#     my_string = list(my_string)
#     for char in my_string:
#         if char not in dict_:
#             dict_[char] = 1
#         else:
#             dict_[char] += 1
    
#     for i in my_string:
#         if i not in answer:
#             answer.append(i)
    for char in my_string:
        if char not in answer:
            answer += char
        
    return answer