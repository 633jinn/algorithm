import sys

input = sys.stdin.readline
from itertools import permutations

N, M = map(int, input().split())
nums = [i for i in range(1, N + 1)]

nPr = list(permutations(nums, M))
for i in nPr:
    print(*i, end=" ")
    print()
