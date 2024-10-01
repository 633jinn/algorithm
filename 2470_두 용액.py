import sys

input = sys.stdin.readline

N = int(input())
solutions = list(map(int, input().split()))
solutions.sort(key=abs, reverse=True)
sol1 = solutions[0]
sol2 = solutions[1]
idx = 0
for i in range(1, len(solutions) - 1):
    x1 = solutions[i]
    x2 = solutions[i+1]
    if abs(sol1+sol2) > abs(x1 + x2):
        idx = i
        sol1 = x1
        sol2 = x2


print(min(sol1, sol2), max(sol1, sol2))
