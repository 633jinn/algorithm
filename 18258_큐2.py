from collections import deque
import sys
input = sys.stdin.readline
N = int(input())
Q = deque()
size = 0
for i in range(N):
    L = list(input().split())
    if L[0] == "push":
        Q.append(L[1])
        size += 1
    elif L[0] == "pop":
        if size:
            print(Q.popleft())
            size -= 1
        else:
            print(-1)
    elif L[0] == "size":
        print(size)
    elif L[0] == "empty":
        if Q:
            print(0)
        else:
            print(1)
    elif L[0] == "front":
        if size != 0:
            print(Q[0])
        else:
            print(-1)
    elif L[0] == "back":
        if size != 0:
            print(Q[-1])
        else:
            print(-1)