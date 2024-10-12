import sys

input = sys.stdin.readline

N, K = map(int, input().split())

lst = [list(map(int, input().split())) for _ in range(N)]
values = [[0]*(K+1) for _ in range(N+1)]

for i in range(1, N + 1):
    for j in range(1, K + 1):
        weight = lst[i - 1][0]
        value = lst[i - 1][1]
        if j >= weight:
            values[i][j] = max(values[i - 1][j], values[i - 1][j - weight] + value)
        else:
            values[i][j] = values[i - 1][j]
print(values[N][K])
