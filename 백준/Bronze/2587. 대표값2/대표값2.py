num = []
for i in range(5):
    num.append(int(input()))
num.sort()
avg = round(sum(num) / len(num))
median = num[2]
print(avg)
print(median)