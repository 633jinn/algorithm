import sys

input = sys.stdin.readline
N = int(input())
lst = [True for i in range(N + 1)]
n = int(N ** 0.5) + 1
lst[0], lst[1] = False, False

for i in range(2, int(n ** 0.5) + 1):
    if lst[i]:
        for j in range(i * 2, n + 1, i):
            lst[j] = False
Prime = []
for i in range(2, N + 1):
    if N == 1:
        break
    if lst[i]:
        while N % i == 0:
            N = N // i
            Prime.append(i)
for i in Prime:
    print(i)
