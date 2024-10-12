import sys

input = sys.stdin.readline

# 최소로 전깃줄을 없애야한다 = 최대로 남겨둘 수 있는그룹을 찾는다

n = int(input())
line = list()
for i in range(n):
    a, b = map(int, input().split())
    line.append((a, b))
line = sorted(line, key=lambda x: x[0])
LIS = [1] * n
for i in range(1, n):
    for j in range(i):
        if line[i][1] > line[j][1]:
            LIS[i] = max(LIS[i], LIS[j] + 1)
print(n - max(LIS))
