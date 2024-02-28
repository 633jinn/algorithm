import sys
from itertools import permutations

input = sys.stdin.readline

N = int(input())
a = list(map(int, input().split()))
a = list(permutations(a))

result = 0


for i in range(len(a)):
    x = 0
    for j in range(N - 1):
        x += abs(a[i][j] - a[i][j - 1])
    if x > result:
        result = x

print(result)
