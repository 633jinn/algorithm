import heapq
import sys

input = sys.stdin.readline

V, E = map(int, input().split())
K = int(input())

# 간선의 값을 저장하기 위한 2차원 배열(메로리 문제로 인해 딕셔너리)
graph = [[] for _ in range(V)]

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u-1].append([v-1, w])

# K에서 다른 정점 사이의 최소 거리를 구하기 위한 배열
distance = [sys.maxsize for _ in range(V)]


def dijkstra(idx):
    distance[idx] = 0
    heap = []
    heapq.heappush(heap, (distance[idx], idx))

    while heap: # heap에 값이 남아있을 때까지

        dist, now = heapq.heappop(heap) #우선순위(가중치) 기준 최소 값을 pop

        # distance 값보다 현재 거리가 길다면, 이미 방문한 정점임
        if distance[now] < dist:
            continue

        for n in graph[now]:
            # 저장된 i 까지의 거리 + i->j의 간선의 값이
            # 저장된 최소 j까지 거리 보다 작다면 업데이트
            if distance[now] + n[1] < distance[n[0]]:
                distance[n[0]] = distance[now] + n[1]
                heapq.heappush(heap, (distance[n[0]], n[0]))

    return distance


result = dijkstra(K - 1)

for i in result:
    if i == sys.maxsize:
        print('INF')
    else:
        print(i)
