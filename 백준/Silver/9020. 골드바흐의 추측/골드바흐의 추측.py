import sys

def is_prime(num):
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    return True
        
for _ in range(int(input())):
    n = int(sys.stdin.readline())
    a, b = n // 2, n // 2
    while a > 0:
        if not is_prime(a) or not is_prime(b):
            a -= 1
            b += 1
        elif is_prime(a) or is_prime(b):
            print(a, b)
            break