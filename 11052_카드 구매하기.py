import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
arr = [0] + list(map(int,input().split()))

count = [0 for i in range(N+1)]
que = deque()
que.append(1)

while que:
    q = que.popleft()
    for i in range(q):
        count[q] = max(count[q], arr[q-i] + count[i])
    if q == N:
        print(count[q])
        break
    else:
        que.append(q+1)


