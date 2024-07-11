import sys
from typing import Any
input = sys.stdin.readline

class Node:
    # 생성자
    def __init__(self, left: Any = None, right: Any = None) -> None:
        self.left = left # 왼쪽 자식 노드
        self.right = right # 오른쪽 자식 노드
    
# 루트가 언제 출력되느냐를 기준으로 print문 위치 설정

# 전위 순회
def preorder_search(node: str = None):
    if node != ".":
        print(node, end="")
        preorder_search(tree[node].left)
        preorder_search(tree[node].right)

# 중위 순회
def inorder_search(node: str = None):
    if node != ".":
        inorder_search(tree[node].left)
        print(node, end="")
        inorder_search(tree[node].right)

# 후위 순회
def postorder_search(node: str = None):
    if node != ".":
        postorder_search(tree[node].left)
        postorder_search(tree[node].right)
        print(node, end="")

n = int(input())
tree = {}
for _ in range(n):
    parent, left, right = input().strip().split()
    tree[parent] = Node(left, right)

root = "A"
preorder_search(root)
print()
inorder_search(root)
print()
postorder_search(root)