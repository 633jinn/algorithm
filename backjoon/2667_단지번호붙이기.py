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
            if (0 <= new_i <= N - 1) and (0 <= new_j <= N - 1):
                # 방문하지 않았는가?
                if not visited[new_i][new_j]:
                    if graph[new_i][new_j] == 1:
                        visited[new_i][new_j] = True
                        Q.append((new_i, new_j))
    return len(v)


N = int(input())
graph = [[int(x) for x in input()] for y in range(N)]
visited = [[False for x in range(N)] for y in range(N)]  # 방문 처리 배열

cnt = 0
arr = []
for i in range(N):
    for j in range(N):
        if not visited[i][j] and graph[i][j] == 1:
            ret = bfs(i, j)
            cnt += 1
            arr.append(ret)
print(cnt)
arr.sort()
for num in arr:
    print(num)
