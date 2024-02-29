import sys

input = sys.stdin.readline

N, M = map(int, input().split())  # N : 행, M : 열
x, y, direction = map(int, input().split())  # 청소기의 현재 위치
arr = list()
clean = 0
for _ in range(N):
    arr.append(list(map(int, input().split())))
while True:
    check = False
    if arr[x][y] == 0:  # 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        arr[x][y] = 2  # 칸이 2면 청소한 것
        clean += 1
    if ((x == 0 and arr[x + 1][y] == 0) or (x == N - 1 and arr[x - 1][y] == 0)  # 청소기가 가장자리에 있을 경우
            or (y == 0 and arr[x][y + 1] == 0) or (y == M - 1 and arr[x][y - 1] == 0)):
        check = True
    elif ((0 < x < N - 1 and 0 < y < M - 1) and
          not arr[x + 1][y] or not arr[x - 1][y] or not arr[x][y + 1] or not arr[x][y - 1]):  # 청소기가 가장자리에 없을 경우
        check = True

    if check:  # 3. 청소되지 않는 칸이 있는 경우
        if direction == 0:
            direction = 3
        else:
            direction -= 1

        if direction == 0 and x > 0 and arr[x - 1][y] == 0:
            x = x - 1
        elif direction == 1 and y < M - 1 and arr[x][y + 1] == 0:
            y = y + 1
        elif direction == 2 and x < N - 1 and arr[x + 1][y] == 0:
            x = x + 1
        elif direction == 3 and y > 0 and arr[x][y - 1] == 0:
            y = y - 1
    else:  # 2. 청소되지 않는 칸이 없는 경우
        if direction == 0 and x < N - 1 and arr[x + 1][y] != 1:
            x = x + 1
        elif direction == 1 and y > 0 and arr[x][y - 1] != 1:
            y = y - 1
        elif direction == 2 and x > 0 and arr[x - 1][y] != 1:
            x = x - 1
        elif direction == 3 and y < M - 1 and arr[x][y + 1] != 1:
            y = y + 1
        else:
            break
print(clean)
