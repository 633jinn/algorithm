import sys
from collections import deque
input = sys.stdin.readline
N = int(input())


def chess():
    global now
    while que:
        now = que.popleft()
        if now == goal:
            return board[goal[0]][goal[1]]
        if now[0] - 2 >= 0: #위
            if now[1] - 1 >= 0 and board[now[0] - 2][now[1] - 1] == 0:
                board[now[0] - 2][now[1] - 1] = board[now[0]][now[1]] + 1
                que.append((now[0] - 2, now[1] - 1))
            if now[1] + 1 <= size - 1 and board[now[0] - 2][now[1] + 1] == 0:
                board[now[0] - 2][now[1] + 1] = board[now[0]][now[1]] + 1
                que.append((now[0] - 2, now[1] + 1))
        if now[0] + 2 <= size - 1: #아래
            if now[1] - 1 >= 0 and board[now[0] + 2][now[1] - 1] == 0:
                board[now[0] + 2][now[1] - 1] = board[now[0]][now[1]] + 1
                que.append((now[0] + 2, now[1] - 1))
            if now[1] + 1 <= size - 1 and board[now[0] + 2][now[1] + 1] == 0:
                board[now[0] + 2][now[1] + 1] = board[now[0]][now[1]] + 1
                que.append((now[0] + 2, now[1] + 1))
        if now[1] - 2 >= 0:#왼쪽
            if now[0] - 1 >= 0 and board[now[0] - 1][now[1] - 2] == 0:
                board[now[0] - 1][now[1] - 2] = board[now[0]][now[1]] + 1
                que.append((now[0] - 1, now[1] - 2))
            if now[0] + 1 <= size - 1 and board[now[0] + 1][now[1] - 2] == 0:
                board[now[0] + 1][now[1] - 2] = board[now[0]][now[1]] + 1
                que.append((now[0] + 1, now[1] - 2))
        if now[1] + 2 <= size -1 : #오른쪽
            if now[0] - 1 >= 0 and board[now[0] - 1][now[1] + 2] == 0:
                board[now[0] - 1][now[1] + 2] = board[now[0]][now[1]] + 1
                que.append((now[0] - 1, now[1] + 2))
            if now[0] + 1 <= size - 1 and board[now[0] + 1][now[1] + 2] == 0:
                board[now[0] + 1][now[1] + 2] = board[now[0]][now[1]] + 1
                que.append((now[0] + 1, now[1] + 2))
        if board[goal[0]][goal[1]] != 0:
            return board[goal[0]][goal[1]]


for _ in range(N):
    size = int(input())
    que = deque()
    board = [[0 for _ in range(size)] for _ in range(size)]
    now = tuple(map(int, input().split()))
    goal = tuple(map(int, input().split()))
    que.append(now)
    print(chess())
