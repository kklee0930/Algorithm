def solution(numbers, target):
    answer = 0
    i = curr_n = 0 # i = 인덱스, curr_n = 현재 숫자
    
    def dfs(nums, target, i, curr_n): # [4,1,2,1], 4, 0, 0
        if i == len(nums): # 0,1,2,3
            if curr_n == target:
                return 1
            else:
                return 0
        
        return dfs(nums, target, i+1, curr_n + nums[i]) + dfs(nums, target, i+1, curr_n - nums[i])
    
    answer = dfs(numbers, target, i, curr_n)
    return answer