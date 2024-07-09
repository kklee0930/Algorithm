import sys
input = sys.stdin.readline

# 루트노드의 인덱스가 0이다.
class MaxHeap:
    def __init__(self) -> None:
        self.heap = []
        
    # 힙에 값 추가
    def push(self, num: int):
        self.heap.append(num)
        self.shift_up(len(self.heap) - 1)
        
    # 힙의 최댓값 삭제
    def pop(self):
        if len(self.heap) == 0:
            return 0
        if len(self.heap) == 1:
            return self.heap.pop()
        root = self.heap[0] # 삭제한 최댓값 리턴을 위한 변수
        self.heap[0] = self.heap.pop() # 최솟값을 빼서 최댓값의 위치로 삽입
        self.shift_down(0) # 대소비교 시작
        return root
        
    # 자식 노드와 대소관계 비교하며 노드 값 이동(자식보다 작으면 이동)
    def shift_down(self, idx):
        parent = idx
        # 자식노드
        left = 2 * parent + 1
        right = 2 * parent + 2
        
        # 자식노드가 부모노드보다 더 크면 위치 변경
        if len(self.heap) > left and self.heap[left] > self.heap[parent]:
            parent = left
        if len(self.heap) > right and self.heap[right] > self.heap[parent]:
            parent = right
        if parent != idx: # 대소관계가 변경이 되었다면
            self.heap[parent], self.heap[idx] = self.heap[idx], self.heap[parent]
            self.shift_down(parent)
    
    # 부모 노드와 대소관계 비교하며 노드 값 이동(부모보다 크면 이동)
    def shift_up(self, child: int):
        parent = (child - 1) // 2
        if parent >= 0 and self.heap[parent] < self.heap[child]:
            self.heap[parent], self.heap[child] = self.heap[child], self.heap[parent]
            self.shift_up(parent)

max_heap = MaxHeap()
cnt = 0

for _ in range(int(input())):
    n = int(input())
    
    if n == 0:
        print(max_heap.pop())
    else:
        max_heap.push(n)