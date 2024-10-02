import sys
import heapq
input = sys.stdin.readline

N, K = map(int, input().split())

heap = []
time = [sys.maxsize for _ in range(100001)]
time[N] = 0


def dijkstra():
    heapq.heappush(heap, (0, N))
    while heap:
        sec, idx = heapq.heappop(heap)
        if time[idx] < sec:
            continue
        if idx + 1 <= K and time[idx + 1] > sec + 1:
            time[idx + 1] = sec + 1
            heapq.heappush(heap, (sec + 1, idx + 1))
        if idx - 1 >= 0 and time[idx - 1] > sec + 1:
            time[idx - 1] = sec + 1
            heapq.heappush(heap, (sec + 1, idx - 1))
        if idx * 2 <= K+1 and time[idx * 2] > sec:
            time[idx * 2] = sec
            heapq.heappush(heap, (sec, idx * 2))


dijkstra()

print(time[K])
