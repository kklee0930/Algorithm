word = input() # 검색 범위 단어
n = input() # 검색하려는 단어
count = 0 # 검색하려는 단어 갯수
start = 0 # 매 iteration마다의 시작점

for i in range(len(word)): # 검색 범위 단어 길이
    if word[start:start+len(n)] == n: # 시작지점부터 시작지점 + 검색하려는 단어 길이 == 검색단어
        count += 1 # 등장횟수 += 1
        start += len(n) # 검색시작지점 초기화(검색 끝 지점 이후로부터 시작)
    else:
        start += 1 # 없을 경우 시작지점 한칸뒤로 초기화
        
print(count)