import sys

input = sys.stdin.readline
from collections import deque


def bfs(start_i, start_j):
    Q = deque()  # 큐
    Q.append((start_i, start_j))
    visited[start_i][start_j] = True
    il = [-1, 1, 0, 0]
    jl = [0, 0, -1, 1]

    v = set()

    while Q:
        node_i, node_j = Q.popleft()
        v.add((node_i, node_j))
        visited[node_i][node_j] = True
        for c in range(4):
            new_i = node_i + il[c]  # 각각 순서대로 -1,1,0,0
            new_j = node_j + jl[c]  # 각각 순서대로 0,0,-1,1
            # 그리드 안에 있는가?
            if (0 <= new_i <= N - 1) and (0 <= new_j <= M - 1):
                # 방문하지 않았는가?
                if not visited[new_i][new_j]:
                    if field[new_i][new_j]:
                        visited[new_i][new_j] = True
                        Q.append((new_i, new_j))


T = int(input())

for t in range(T):
    M, N, K = map(int, input().split())
    field = [[False for x in range(M)] for y in range(N)]
    visited = [[False for x in range(M)] for y in range(N)]

    for i in range(K):
        X, Y = map(int, input().split())
        field[Y][X] = True
    cnt = 0
    for i in range(N):
        for j in range(M):
            if (not visited[i][j]) and field[i][j]:
                bfs(i, j)
                cnt += 1
    print(cnt)
