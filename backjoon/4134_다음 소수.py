import sys

input = sys.stdin.readline

def isPrime(number):
    if number == 1 or number==0:
        return False
    if number == 2:
        return True
    for x in range(2, int(number ** 0.5) + 1):
        if number % x == 0:
            return False
    return True


x = int(input())
for i in range(x):
    res = int(input())
    while not(isPrime(res)):
        res+=1
    print(res)