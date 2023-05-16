import sys
input = sys.stdin.readline

def isPrime(num):

    if num == 1:
        return False
    if num == 2:
        return True
    for a in range(2, int(num ** 0.5) + 1):
        if num % a == 0:
            return False
    return True


N = int(input())
arr = list(map(int, input().split()))

count=0
for i in arr:
    if isPrime(i):
        count+=1
print(count)