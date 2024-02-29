import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
lst = []
count = [1, 2, 2, 2, 2, 2, 2, 2, 2, 1]
n = 2
if N == 1:
    print(9)
elif N == 2:
    print(17)
else:
    for i in range(3, N + 1):
        lst = [0 for _ in range(10)]
        for j in range(0, 9 + 1):
            if j == 0:
                lst[j] = count[j + 1]
            elif j == 9:
                lst[j] = count[j - 1]
            else:
                lst[j] = count[j - 1] + count[j + 1]

        count = lst
    print(sum(count[1:])%1000000000)