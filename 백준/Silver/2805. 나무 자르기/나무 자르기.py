import sys
input = sys.stdin.readline

n, m = map(int, input().split())
tree_list = list(map(int, input().split()))

left, right = 0, max(tree_list)

while left <= right:
    mid = (left + right) // 2
    sum = 0
    
    # 나무의 높이가 자르는 선보다 낮으면 잘리지 않음
    for height in tree_list:
        if height <= mid:
            continue
        sum += height - mid
    
    if sum >= m:
        left = mid + 1
    elif sum < m:
        right = mid - 1

print(right)