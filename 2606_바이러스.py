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


C = int(input())
N = int(input())
graph = [[] for x in range(C + 1)]
visited = [False for x in range(C + 1)]

for i in range(N):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
cnt = 0
bfs(1)
for i in visited:
    if i == True:
        cnt += 1
print(cnt - 1)
