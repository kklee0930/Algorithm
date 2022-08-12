def pprint(arr):
    for i in range(len(arr)):
        print(arr[i])

dy = [-1,0,1,0]
dx = [0,1,0,-1]

n,m = list(map(int,input().split()))

graph = []

for _ in range(n):
    graph_list = list(map(int,input().split()))
    graph.append(graph_list)

visited = []

for _ in range(n):
    visited_list = [False] * m
    visited.append(visited_list)

painting_count = 0
painting_size_list = []

for sy in range(n):
    for sx in range(m):
        if not visited[sy][sx] and graph[sy][sx] == 1: 
            stack = []

            stack.append([sy,sx])
            visited[sy][sx] = True
            
            painting_count += 1
            painting_size = 0

            while len(stack) != 0:
                y, x = stack.pop()

                painting_size += 1

                for d in range(4):
                    ny = y + dy[d]
                    nx = x + dx[d]

                    if not (-1< ny < n and -1 < nx < m):
                        continue

                    if visited[ny][nx] == True:
                        continue

                    if graph[ny][nx] != 1:
                        continue

                    stack.append((ny,nx))
                    visited[ny][nx] = True

            painting_size_list.append(painting_size)
            
if len(painting_size_list) != 0:
    print(painting_count)
    print(max(painting_size_list))
else:
    print(0)
    print(0)