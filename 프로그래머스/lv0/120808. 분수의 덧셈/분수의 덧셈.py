def solution(numer1, denom1, numer2, denom2):
    def get_GCD(x, y):
        while y:
            x, y = y, x % y
        return x
    
    # 약분해주기
    GCD1 = get_GCD(numer1, denom1)
    numer1, denom1 = numer1 // GCD1, denom1 // GCD1
    
    GCD2 = get_GCD(numer2, denom2)
    numer2, denom2 = numer2 // GCD2, denom2 // GCD2
        
    # GCD 구하기(유클리드 호제법 이용)
    GCD = get_GCD(denom1, denom2)
    
    # LCM 구하기
    LCM = (denom1 * denom2) // GCD
    
    numer1 *= LCM // denom1
    numer2 *= LCM // denom2
    numerator = numer1 + numer2

    GCD_ = get_GCD(numerator, LCM)
    
    numerator, LCM = numerator // GCD_, LCM // GCD_
    
    return [numerator, LCM]