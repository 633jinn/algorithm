import sys
input = sys.stdin.readline

N = int(input())
stack = []
size = 0
for i in range(N):
    L = list(input().split())
    if L[0] == "push":
        stack.append(L[1])
        size += 1
    elif L[0] == "pop":
        if size:
            print(stack.pop(-1))
            size -= 1
        else:
            print(-1)
    elif L[0] == "size":
        print(size)
    elif L[0] == "empty":
        if stack:
            print(0)
        else:
            print(1)
    elif L[0] == "top":
        if size != 0:
            print(stack[-1])
        else:
            print(-1)
