burgers = []
drinks = []
result = []
for i in range(3):
    burgers.append(int(input()))
for j in range(2):
    drinks.append(int(input()))

for i in range(len(burgers)):
    for j in range(len(drinks)):
        result.append(burgers[i] + drinks[j] - 50)
print(min(result))