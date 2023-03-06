def solution(a, b):
    months = [31,29,31,30,31,30,31,31,30,31,30,31] # 달의 일수
    days = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU'] #1월1일은 금요일
    # if a == 1: # 1월이면 1일과 차이가 며칠나는지 계산하여 days[index]
    #     b -= 1
    #     answer = days[b]
    #     return answer
    # else: # 1월이 아닐경우
    left_days = sum(months[:a]) - months[a-1] + b - 1 # 1월~a월 모든 일수 - a월 일수 + b
    print(left_days)
    answer = days[left_days % 7]
    return answer