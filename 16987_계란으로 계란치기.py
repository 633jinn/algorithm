import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
que = deque()
shield = []
weight = []
for i in range(N):
    s, w = map(int, input().split())
    shield.append(s)
    weight.append(w)
    que.append(i)
result = [0 for i in range(N)]
count = 0
q = que.popleft()
num = q
while True:
    mi = min(shield)
    idx = shield.index(mi)
    we = weight[idx]
    if num == N - 1:
        q = que.popleft()
        num = q
    if q == N - 1:
        break
    if mi - weight[q] <= 0:
        weight.pop(idx)
        shield.pop(idx)
        result[num] += 1
    if shield[q] - we <= 0:
        weight.pop(q)
        shield.pop(q)
        num += 1
        result[num] += 1

print(max(result))
