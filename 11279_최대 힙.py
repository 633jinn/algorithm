import heapq
import sys
input = sys.stdin.readline

N = int(input())
heap = []
for i in range(N):
    n = int(input())
    if n != 0:
        heapq.heappush(heap, n*(-1))  # heap은 넣어줄 리스트, n은 넣을 값
    else:
        if heap:
            print(heapq.heappop(heap)*(-1))
        else:
            print(0)
