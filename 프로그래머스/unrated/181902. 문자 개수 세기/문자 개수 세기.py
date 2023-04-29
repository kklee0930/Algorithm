def solution(my_string):
    ans1 = [0] * 26
    ans2 = [0] * 26
    for s in my_string: # ord('A') = 65, ord('Z') = 90, ord('a') = 97, ord('z') = 122
        if ord(s) in range(65, 91):
            ans1[ord(s) - 65] += 1
        elif ord(s) in range(97, 123):
            ans2[ord(s) - 97] += 1
    return ans1 + ans2