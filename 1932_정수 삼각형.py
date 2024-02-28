import sys

input = sys.stdin.readline

n = int(input())
# rectangle = [[]]
# for i in range(n):
#     rectangle.append(list(map(int, input().split())))

result = [[0 for _ in range(i)] for i in range(n + 1)]
c = 0
r = 1
rectangle = list(map(int, input().split()))
result[1][0] = rectangle[0]
lastResult = rectangle[0]
if n>1:
    rectangle = list(map(int, input().split()))
    while True:
        if r == n - 1:
            lastResult = max(lastResult, result[r][c] + rectangle[c], result[r][c] + rectangle[c+1])
            c += 1
        elif r != n:
            result[r + 1][c + 1] = max(result[r][c] + rectangle[c+1], result[r+1][c+1])  # 대각선 오른쪽 값
            result[r + 1][c] = max(result[r][c] + rectangle[c], result[r + 1][c])  # 대각선 왼쪽 값
            c += 1

        if c == n - 1 and r == n - 1:
            break
        if c == r:  # column 끝까지 가면
            r = r + 1
            c = 0
            rectangle = list(map(int, input().split()))

print(lastResult)
