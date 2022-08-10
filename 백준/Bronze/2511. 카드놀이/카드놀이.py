A = list(map(int,input().split()))
B = list(map(int,input().split()))

A_score = 0
B_score = 0

last_winner = '0'

for i in range(10):
    if A[i] > B[i]:
        A_score += 3
        last_winner = 'A'
    elif B[i] > A[i]:
        B_score += 3
        last_winner = 'B'
    elif A[i] == B[i]:
        A_score += 1
        B_score += 1

if A_score > B_score:
    winner = 'A'
elif B_score > A_score:
    winner = 'B'
elif A_score == B_score:
    if last_winner == 'A':
        winner = 'A'
    elif last_winner == 'B':
        winner = 'B'
    elif last_winner == '0':
        winner = 'D'

print(A_score, B_score)
print(winner)