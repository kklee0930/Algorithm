def solution(n, lost, reserve):
    answer = 0
    students = []
    
    for student in range(1, n+1): # 모든 학생은 1벌의 체육복을 가지는 것으로 시작
        students.append([student, 1])
        
    for stud in students:
        if stud[0] in lost: # 학생 번호가 lost에 있으면 체육복 -= 1
            stud[1] -= 1
        if stud[0] in reserve: # reserve에 있으면 체육복 += 1
            stud[1] += 1
    
    for i in range(len(students)):
        if students[i][1] == 0: # 가진 체육복이 없으면
            if i in range(1, len(students)-1): # 학생의 번호가 양끝의 번호가 아니라면
                prev, after = i-1, i+1
                
                if students[prev][1] > 1: # 이전번호 학생이 여분이 있으면 빌린다
                    students[prev][1] -= 1
                    students[i][1] += 1
                
                elif students[after][1] > 1: # 다음번호 학생이 여분이 있으면 빌린다
                    students[after][1] -= 1
                    students[i][1] += 1
                
            elif i == 0: # 첫번째 번호라면
                after = i+1
                if students[after][1] > 1: # 다음번호 학생이 여분이 있으면 빌린다
                    students[after][1] -= 1
                    students[i][1] += 1
                
            elif i == len(students)-1: # 마지막 번호라면
                prev = i-1
                if students[prev][1] > 1: # 이전번호 학생이 여분이 있으면 빌린다
                    students[prev][1] -= 1
                    students[i][1] += 1
    
    for student in students:
        if student[1] >= 1:
            answer += 1
    return answer