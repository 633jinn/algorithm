from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
Deque = deque()
size = 0
for i in range(N):
    L = list(input().split())
    if L[0] == "push_front":
        Deque.appendleft(L[1])
        size += 1
    elif L[0] == "push_back":
        Deque.append(L[1])
        size += 1
    elif L[0] == "pop_front":
        if size!=0:
            print(Deque.popleft())
            size -= 1
        else:
            print(-1)
    elif L[0] == "pop_back":
        if size!=0:
            print(Deque.pop())
            size -= 1
        else:
            print(-1)
    elif L[0] == "size":
        print(size)
    elif L[0] == "empty":
        if Deque:
            print(0)
        else:
            print(1)
    elif L[0] == "front":
        if size != 0:
            print(Deque[0])
        else:
            print(-1)
    elif L[0] == "back":
        if size != 0:
            print(Deque[-1])
        else:
            print(-1)