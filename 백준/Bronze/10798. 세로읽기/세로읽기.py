matrix = [input() for _ in range(5)]

max_val = max(map(len, matrix))

result = []

for col in range(int(max_val)):
    for row in range(5):
        try:
            result.append(matrix[row][col])
        except:
            continue
print(''.join(result))