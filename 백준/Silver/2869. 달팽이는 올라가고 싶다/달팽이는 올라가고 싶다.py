from math import ceil

ascend,descend,goal = map(int, input().split())
height = goal - descend
progress = ascend - descend
print(ceil(height/progress))