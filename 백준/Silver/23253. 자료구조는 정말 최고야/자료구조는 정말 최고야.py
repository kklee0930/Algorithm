# N: 교과서의 수, M: 더미의 수
N,M = map(int,input().split())
fail = 0

for i in range(M): # 더미의 수
    book_cnt = int(input()) # 책의 갯수 (2)
    book_lst = list(map(int,input().split())) # [[3,1],[4,2]]
    for j in range(book_cnt-1):
        if book_lst[j] < book_lst[j+1]:
            fail = True
            break
        
if fail == True:
    print('No')
else:
    print('Yes')