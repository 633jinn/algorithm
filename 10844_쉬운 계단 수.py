import sys

input = sys.stdin.readline

from collections import deque

N = int(input())
result = [0 for i in range(N+1)]

result[1] = 9
result[2] = 17
que = deque()
num = deque()
for i in range(N):
    que.append(i)
    num.append(1)
    if i == 9:
        break
lst = []
while True:
    q = que.popleft()
    n = num.popleft()
    if 
    if q == 0:
        que.appendleft(1)
    elif q == 9:
        que.appendleft(9)
    else:
        que.appendleft(q+1)
        que.appendleft(q-1)

print(result[N])