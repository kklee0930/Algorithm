N = int(input())
count = 0
for i in range(1, N+1):
    word = input()
    word_checker =''
    for j in word:
        if j not in word_checker:
            word_checker += j

        elif word_checker[-1] == j:
            word_checker += j

        elif word_checker[-1] != j and j in word_checker:
            break
    else:
        count+=1
print(count)