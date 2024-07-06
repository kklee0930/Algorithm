import sys

N = int(sys.stdin.readline())
target_list = sorted(map(int, sys.stdin.readline().strip().split()))

M = int(sys.stdin.readline())
iter_list = map(int, sys.stdin.readline().strip().split())

def binary_search(start, end, num):
    while start <= end:
        mid = (start + end) // 2

        if target_list[mid] == num:
            return 1
            
        elif target_list[mid] < num:
            start = mid + 1
            
        else:
            end = mid - 1
    return 0
    
for num in iter_list:
    print(binary_search(0, N-1, num))