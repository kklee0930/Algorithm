def solution(a, b, n): # 교환에 소요되는 빈병, 교환시 받는 콜라, 가지고 있는 빈병
    answer = 0
    while n >= a: # 가진 빈병이 소요되는 빈병보다 많을 경우에만
        extra = (n // a) * b # 빈병 교환해서 받는 콜라
        answer +=  extra # 지금까지 받은 콜라
        remainder = n % a # 교환하고 남는 빈병
        n = remainder + extra # 총 빈병의 수
    return answer