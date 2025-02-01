import sys

input = sys.stdin.readline


def isPrime(number):
    if number == 1 and number == 2:
        return True
    for x in range(2, int(number ** 0.5) + 1):
        if number % x == 0:
            return False
    return True


dic = dict()
for a in range(97, 123):
    dic[chr(a)] = a - 96
for a in range(65, 91):
    dic[chr(a)] = a - 38

string = input().rstrip()
num = 0
for i in string:
    num += dic[i]


if isPrime(num):
    print("It is a prime word.")
else:
    print("It is not a prime word.")

