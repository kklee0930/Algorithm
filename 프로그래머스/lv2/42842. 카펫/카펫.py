def solution(brown, yellow):
    answer = []
    # 노란 타일을 기준으로 갈색타일의 갯수 계산
    for width in range(1, yellow + 1):
        result = 0
        height = yellow / width
        
        if (width >= height) and (yellow % width == 0): # 가로 길이가 세로와 같거나 노란 면적이 사각형인 경우에만
            yellow = width * height # 노란타일 갯수
            w = (width + 2) * 2 # 갈색타일
            h = (height + 2) * 2 # 갈색타일
            result = yellow + h + w - 4 # 노란타일 갯수 + 갈색 가로 테두리 + 갈색 세로 테두리 - 겹치는 부분
            
        if result == brown + yellow: # 타일의 총합
            answer.extend([width + 2, height + 2])
            return answer