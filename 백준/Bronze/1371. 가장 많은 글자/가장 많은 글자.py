from sys import stdin

sentence = stdin.read()
string_ = sentence.replace('\n','').replace(' ','')

char_ = [0 for _ in range(26)] # 알파벳 갯수만큼 0으로 찬 리스트 생성

for i in string_:
    char_[ord(i) - 97] += 1 # 아스키 코드 변환하여 -97 하여 인덱스에 횟수 반영
    
max_val = max(char_)

result = []

for j in range(len(char_)):
    if char_[j] == max_val: # 문자의 횟수 == 전체 리스트의 max
        result.append(chr(j + 97)) # index == ord(알파벳) - 97 이므로 chr(index + 97)
        
print(''.join(result))   
