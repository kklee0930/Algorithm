def solution(genres, plays):
    answer = []
    gen_dict = {} # {장르이름: 장르 누적 재생횟수} {'classic': 1450}
    play_no = {} # {고유 번호: [장르, 재생횟수]}
    
    for i, genre in enumerate(genres):
        if genre not in gen_dict:
            gen_dict[genre] = plays[i]
        else:
            gen_dict[genre] += plays[i]
        play_no[i] = [genre, plays[i]]
    
    while gen_dict:
        max_genre = list(gen_dict.keys())[list(gen_dict.values()).index(max(gen_dict.values()))]
        del gen_dict[max_genre] # 가장 많이 재생된 장르 선정 후 해시에서 제거(1번 조건 해당)
        # 장르 == max_genre인 것을 뽑아서 [[고유번호, 재생횟수]] 형태의 리스트로 저장
        li = [[k, v[1]] for k, v in play_no.items() if v[0] == max_genre]
        for n in li:
            del play_no[n[0]] # 마찬가지로 고유번호에 해당되는 데이터 play_no 해시에서 삭제
        song_no = sorted(li, key=lambda x: (x[1], -x[0])) # 2번조건, 3번조건 해당
        temp = [] # 장르 내에서 상위 랭크 2의 임시로 담기 위한 리스트
        while song_no and len(temp) < 2:
            temp.append(song_no.pop()[0])
        answer.extend(temp)
            
    return answer
        