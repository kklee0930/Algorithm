def solution(id_list, report, k):
    reporter_dict = {}
    for id in id_list:
        reporter_dict[id] = []
    
    reported_dict = {}
    for data in report:
        reporter, reported = data.split()
        if reported not in reporter_dict[reporter]:
            reporter_dict[reporter].append(reported)
        
            if reported not in reported_dict:
                reported_dict[reported] = 1
            else:
                reported_dict[reported] += 1
                
    answer = []
    for reporter in id_list:
        count = 0
        for reported in reporter_dict[reporter]:
            if reported_dict[reported] >= k:
                count += 1
        answer.append(count)
    return answer