import sys

input = sys.stdin.readline
from collections import deque


def bfs(start):
    Q = deque()
    Q.append(start)
    visited[start] = True

    while Q:
        node = Q.popleft()
        visited[node] = True
        for d in graph[node]:
            if not visited[d]:
                visited[d] = True
                Q.append(d)


V, E = map(int, input().split())
graph = [[] for x in range(V + 1)]

for i in range(E):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for x in range(V + 1)]

cnt = 0
for i in range(1, V + 1):
    if not visited[i]:
        bfs(i)
        cnt += 1

print(cnt)