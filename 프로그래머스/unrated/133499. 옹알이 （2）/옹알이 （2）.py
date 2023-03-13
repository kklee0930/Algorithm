def solution(babbling):
    answer = 0
    speakable = ['aya', 'ye', 'woo', 'ma']

    for word in babbling: # ['aya', 'yee', 'u', 'maa']
        str_ = ''
        cnt = 0
        prev_word = ''
        for char in word: # 'a','y','a'와 같은 알파벳
            str_ += char # 알파벳 하나씩을 더해줌
            if str_ in speakable and str_ != prev_word: # 말할 수 있는 단어이고 연속발음이 아닐경우
                prev_word = str_
                cnt += 1
                str_ = '' 

        if cnt >= 1 and str_ == '':
            answer += 1
    return answer