import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
board = [[0 for _ in range(10)] for _ in range(10)]
ladder = {}
snake = {}
for _ in range(N):
    a, b = map(int, input().split())
    ladder[a - 1] = b - 1
for _ in range(M):
    a, b = map(int, input().split())
    snake[a - 1] = b - 1
que = deque()
que.append((0, 0))

while que:
    q = que.popleft()
    for i in range(1, 7):
        num = q[0] * 10 + q[1] + i
        column = num % 10
        row = num // 10
        if row > 9:
            break
        if board[row][column] == 0 or (board[row][column] != 0 and board[row][column] > board[q[0]][q[1]] + 1):
            if num in ladder:
                board[row][column] = board[q[0]][q[1]] + 1
                if board[ladder[num] // 10][ladder[num] % 10] == 0:
                    board[ladder[num] // 10][ladder[num] % 10] = board[q[0]][q[1]] + 1

                que.append((ladder[num] // 10, ladder[num] % 10))
            elif num in snake:
                board[row][column] = board[q[0]][q[1]] + 1
                if board[snake[num] // 10][snake[num] % 10]== 0:
                    board[snake[num] // 10][snake[num] % 10] = board[q[0]][q[1]] + 1

                que.append((snake[num] // 10, snake[num] % 10))
            else:
                board[row][column] = board[q[0]][q[1]] + 1
                que.append((row, column))
print(board[9][9])
