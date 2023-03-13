def solution(numbers, hand):
    answer = ''
    left_finger = [1,4,7] # 왼쪽 손가락으로 누르는 번호
    right_finger = [3,6,9] # 오른쪽 손가락으로 누르는 번호
    middle_finger = [2,5,8,0] # 양쪽 손가락으로 누르는 번호
    keypad = [[1,2,3], [4,5,6], [7,8,9], ['*',0,'#']] # 위치
    left_position = '*'
    right_position = '#'
    num_idx = []
    
    for num in numbers:
        if num in left_finger: # 왼쪽으로 누를 수 있으면
            answer += 'L'
            left_position = num # 왼손가락 위치 변경
            
        elif num in right_finger: # 오른쪽으로 누를 수 있으면
            answer += 'R'
            right_position = num # 오른손가락 위치 변경
            
        else: # 가운데 위치한 번호이면
            for i in range(4):
                for j in range(3):
                    if keypad[i][j] == num: # 누를 번호의 인덱스 
                        num_idx = [i, j]
                    if keypad[i][j] == right_position: # 현재 오른손가락 인덱스
                        right_idx = [i, j]
                    if keypad[i][j] == left_position: # 현재 왼손가락 인덱스
                        left_idx = [i, j]
                        
            # 두 손가락에서 누르려고 하는 버튼 사이의 거리 구하기
            r_dist = sum([abs(num_idx[0] - right_idx[0]), abs(num_idx[1] - right_idx[1])])
            l_dist = sum([abs(num_idx[0] - left_idx[0]), abs(num_idx[1] - left_idx[1])])
            dist_ = {r_dist: 'R', l_dist: 'L' }
            
            if r_dist == l_dist: # 거리가 동일하다면 dominant hand에 따라 적용
                if hand == 'right':
                    right_position = num
                    answer += 'R'
                else:
                    left_position = num
                    answer += 'L'
                
            else: # 아니라면 거리가 더 짧은 쪽 선택
                answer += dist_[min(r_dist, l_dist)]
                if answer[-1] == 'L': # 누른 손가락에 따라 위치 변경 적용
                    left_position = num
                else:
                    right_position = num
    return answer