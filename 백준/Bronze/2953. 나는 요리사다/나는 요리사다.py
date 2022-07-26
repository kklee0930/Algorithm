from sys import stdin
count = 1
winner = {}
while count < 6: 
    score = map(int, input().split()) 
    score = sum(score) # 입력받은 점수를 더해 score 변수에 저장
    winner[count] = score # dictionary에 {count: score} 로 저장
    count += 1 # 다음 선수
    
max_val = max(winner.values()) # 우승자 점수
print(list(winner.keys())[list(winner.values()).index(max_val)], max_val)