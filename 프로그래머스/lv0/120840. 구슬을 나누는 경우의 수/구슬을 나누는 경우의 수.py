def solution(balls, share): # n, m
    balls_fac = 1
    share_fac = 1
    difference = balls - share # n-m
    difference_fac = 1
    
    while balls > 0:
        balls_fac *= balls
        balls -= 1
    while share > 0:
        share_fac *= share
        share -= 1
    while difference > 0:
        difference_fac *= difference
        difference -= 1
        
    return balls_fac / (difference_fac * share_fac)