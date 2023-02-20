def solution(age):
    list_ = ['a','b','c','d','e','f','g','h','i','j']
    answer = ''
    for i in str(age):
        answer += list_[int(i)]
    return answer