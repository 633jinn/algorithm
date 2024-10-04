import sys
from collections import defaultdict

input = sys.stdin.readline

N = 10 ** 5
arr = [True for i in range(N + 1)]
n = int(N ** 0.5) + 1
arr[0], arr[1] = False, False

for i in range(2, int(n ** 0.5) + 1):
    if arr[i]:
        for j in range(i * 2, n + 1, i):
            arr[j] = False

Prime = []
count = int(input())

for i in range(count):
    N = int(input())
    dic = defaultdict(int)
    for j in range(2, N + 1):
        if N==1:
            break
        while N % j == 0:
            N = N // j
            dic[j] += 1
    for k in dic.keys():
        print(k, dic[k])