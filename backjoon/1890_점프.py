import sys

input = sys.stdin.readline

n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]
dist = [[0] * n for _ in range(n)]

dist[0][0] = 1
for i in range(n):
    for j in range(n):
        if dist[i][j] == 0 or i == n-1 and j == n-1:
            continue

        if j + arr[i][j] < n:
            dist[i][j+arr[i][j]] += dist[i][j]
        if i + arr[i][j] < n:
            dist[i+arr[i][j]][j] += dist[i][j]

print(dist[n-1][n-1])