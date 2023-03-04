def solution(strings, n): 
    # 인덱스 n부터 끝까지를 기준으로 정렬하고, 중복이 있을경우 "첫 문자열"부터 사전 순서대로 정렬
    strings.sort(key=lambda x: (x[n], x[0:]))
    return strings