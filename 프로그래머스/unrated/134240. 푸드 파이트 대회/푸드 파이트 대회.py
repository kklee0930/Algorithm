def solution(food):
    answer = ['0']
    
    for i in range(len(food)-1, 0, -1): # food리스트 역순으로
        amount = food[i] // 2 # 두명의 선수이므로 2의 몫
        if amount == 0: # 몫이 0이면 대회에 제공불가능
            continue
        food_amount = str(i) * amount # 음식 번호 * 수량
        answer.append(str(food_amount)) # 각 선수의 위치대로 제공
        answer.insert(0, str(food_amount))
        
    answer = ''.join(answer)
    return answer