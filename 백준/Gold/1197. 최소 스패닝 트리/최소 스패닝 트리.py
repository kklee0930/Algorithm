import sys
input = sys.stdin.readline

# 노드와 간선
v, e = map(int, input().split())

edge_list = [] # 각 간선에 대한 정보 저장 위한 배열

for _ in range(e):
    # 노드 a와 b사이의 가중치 c
    a, b, c = map(int, input().split())
    edge_list.append((a,b,c))

edge_list.sort(key=lambda x: x[2]) # 가중치 기준으로 정렬

# 모든 노드 배열에 저장(union find)
parent_list = [i for i in range(v+1)]

def get_parent(n):
    # 부모 노드가 자기 자신이면 return
    if parent_list[n] == n:
        return n
    
    # 재귀를 통해 n의 부모 노드를 최상위 부모노드로 갱신
    parent_list[n] = get_parent(parent_list[n])
    return parent_list[n]

# 두 노드 사이에 부모를 설정하는 함수
def union_parent(a, b):
    a = get_parent(a)
    b = get_parent(b)
    
    if a < b: # 작은 쪽을 부모로 설정. 왜?
        parent_list[b] = a
    else:
        parent_list[a] = b

def same_parent(a, b):
    return get_parent(a) == get_parent(b)

answer = 0
for a, b, weight in edge_list:
    if not same_parent(a, b):
        union_parent(a, b)
        answer += weight
        
print(answer)
    