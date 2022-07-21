N = input()
alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']

check = {}
for char in N:
    if char not in check:
        check[char] = N.index(char)
for alp in alphabet:
    if alp in check.keys():
        print(check.get(alp), end=' ')
    else:
        print(-1, end=' ')