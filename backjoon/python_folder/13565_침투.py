import sys

input = sys.stdin.readline
from collections import deque


def bfs(start_i, start_j):
    Q = deque()  # 큐
    Q.append((start_i, start_j))
    visited[start_i][start_j] = True
    il = [-1, 1, 0, 0]
    jl = [0, 0, -1, 1]

    while Q:
        node_i, node_j = Q.popleft()
        visited[node_i][node_j] = True
        for c in range(4):
            new_i = node_i + il[c]  # 각각 순서대로 -1,1,0,0
            new_j = node_j + jl[c]  # 각각 순서대로 0,0,-1,1
            # 그리드 안에 있는가?
            if (0 <= new_i <= N - 1) and (0 <= new_j <= M - 1):
                if not visited[new_i][new_j]:
                    if graph[new_i][new_j] == 0:
                        visited[new_i][new_j] = True
                        Q.append((new_i, new_j))


N, M = map(int, input().split())
graph = [list(map(int, input().rstrip())) for y in range(N)]
visited = [[False for x in range(M)] for y in range(N)]
for i in range(N):
    if (not visited[0][i]) and graph[0][i] == 0:
        bfs(0, i)
if True in visited[N - 1]:
    print("YES")
else:
    print("NO")
