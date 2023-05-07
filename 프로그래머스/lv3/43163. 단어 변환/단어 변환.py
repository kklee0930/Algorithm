def solution(begin, target, words):
    answer = 0
    visited = [0] * len(words)
    check = 0
    
    def dfs(word, target, val):
        nonlocal answer, check
        if word == target:
            check = 1
            answer = val
        else:
            for i in range(len(words)):
                cnt = 0
                for j in range(len(word)):
                    if word[j] != words[i][j]:
                        cnt += 1
                if visited[i] == False and cnt == 1:
                    visited[i] = True
                    dfs(words[i], target, val + 1)
                    visited[i] = False

    dfs(begin, target, 0)
    
    if check:
        return answer
    else:
        return 0