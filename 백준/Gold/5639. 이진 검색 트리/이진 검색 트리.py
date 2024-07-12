import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

arr = []
while True:
    try:
        arr.append(int(input().strip()))
    except:
        break

def solution(arr):
    # 배열의 길이가 0이면 종료
    if len(arr) == 0:
        return
    
    # 왼쪽 서브트리, 오른쪽 서브트리 배열
    left, right = [], []
    # 배열의 첫 번째 원소가 루트
    root = arr[0]
    
    # 전위 순회한 결과 시 루트보다 작은 값이 무조건 먼저 나옴
    for i in range(1, len(arr)):
        if arr[i] > root:
            left = arr[1:i]
            right = arr[i:]
            break
    else:
        # 모든 노드가 root보다 작을 경우
        left = arr[1:]
    
    # 후위 순회
    solution(left)
    solution(right)
    print(root)
    
solution(arr)