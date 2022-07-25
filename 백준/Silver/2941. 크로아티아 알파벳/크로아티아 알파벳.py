word = str(input())
alphabet = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for element in alphabet:
    word = word.replace(element, 'X')
print(len(word))