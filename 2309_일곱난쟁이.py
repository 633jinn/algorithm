from itertools import combinations
import sys

input = sys.stdin.readline

height = list()
for i in range(9):
    height.append(int(input()))
height.sort()
result = list(combinations(height, 7))
for i in range(len(result)):
    if sum(result[i]) == 100:
        for j in result[i]:
            print(j)
        break
