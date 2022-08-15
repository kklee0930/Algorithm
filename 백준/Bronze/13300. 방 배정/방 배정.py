N, K = map(int, input().split())

room_cnt = 0
dict = {
    '1_1': 0,
    '0_1': 0,
    '1_2': 0,
    '0_2': 0,
    '1_3': 0,
    '0_3': 0,
    '1_4': 0,
    '0_4': 0,
    '1_5': 0,
    '0_5': 0,
    '1_6': 0,
    '0_6': 0,
}

for i in range(N):
    gender, grade = map(int,input().split())
    dict[f'{gender}_{grade}'] += 1

for student in dict.values():
    if student != 0:
        if student % K:
            room_cnt += (student // K) + 1
        else:
            room_cnt += (student // K)
print(room_cnt)