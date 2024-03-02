import sys

input = sys.stdin.readline

N = int(input())
top = list(map(int, input().split()))
answer = [0 for _ in range(N)]

stack = []
for i in range(N):
    while stack:
        if top[stack[-1]] < top[i]:
            stack.pop()
        else:
            answer[i] = stack[-1] + 1
            break
    stack.append(i)

print(*answer, end=" ")
