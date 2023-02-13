def solution(babbling):
    speakable = ['aya', 'ye', 'woo', 'ma']
    answer = 0

    for babble in babbling: #["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]
        checker = ''
        count = 0
        for char in babble:
            # checker에 iteration통한 문자열 추가
            checker += char
            # 쌓인 문자열이 speakable에 포함 여부 체크
            if checker in speakable:
                checker = ''
                count += 1
        # 포함여부 확인 및 클리어 여부 확인        
        if count > 0 and checker == '':
            answer += 1
    return answer