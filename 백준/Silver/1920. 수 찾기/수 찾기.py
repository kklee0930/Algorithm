from sys import stdin

N = int(stdin.readline())
targets = sorted(map(int, stdin.readline().split())) # 이 리스트에서 탐색한다.
M = int(stdin.readline())
list_ = map(int, stdin.readline().split()) # for loop문을 통해서 해당 원소가 targets 리스트에 존재하는지 확인한다.

def binarySearch(targets, element, start, end):
    if start > end:
        return 0
    m = (start + end) // 2 # 중간점 지정
    if element == targets[m]: # list_의 element가 탐색구간의 중간점 값과 같으면 출력
        return 1
    elif element < targets[m]: # 작으면 종료점 조정 (중간점 - 1)
        return binarySearch(targets, element, start, m-1)
    else: # 크면 시작점 조정 (중간점 + 1)
        return binarySearch(targets, element, m+1, end)
    
for element in list_: # 이진탐색 위해 시작점과 종료점 설정
    start = 0 
    end = len(targets) - 1
    print(binarySearch(targets, element, start, end))