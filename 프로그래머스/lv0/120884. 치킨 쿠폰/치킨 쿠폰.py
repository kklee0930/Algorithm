def solution(chicken):
    coupon = chicken
    answer = 0
    while coupon >= 10:
        service_chicken = coupon // 10
        answer += service_chicken
        coupon =coupon - service_chicken * 10 + service_chicken 
    return answer