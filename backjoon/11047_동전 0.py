import sys
input = sys.stdin.readline

N, K = map(int, input().split())
x = N - 1
lst = [0 for i in range(N)]
for i in range(N):
    lst[x] = int(input())
    x -= 1

count = 0
for i in range(N):
    while K >= lst[i]:
        K -= lst[i]
        count += 1
    if K == 0:
        break
print(count)
