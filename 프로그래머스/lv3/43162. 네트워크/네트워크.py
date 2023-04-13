def solution(n, computers):
    answer = 0
    def dfs(computers, v, visited):
        visited[v] = True
        for i in range(len(computers[v])):
            if (computers[v][i] == 1) and (not visited[i]):
                dfs(computers, i, visited)
                
    visited = [False] * n # [False, False, False]
    for v in range(n):
        if not visited[v]:
            answer += 1
            dfs(computers, v, visited)
            
    return answer