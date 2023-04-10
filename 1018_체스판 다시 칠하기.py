import sys
input = sys.stdin.readline
from collections import defaultdict

N, M=map(int, input().split())
board=[]
for x in range(N):
    board.append(input())
T=[]

for i in range(N-7):
    for j in range(M-7):
        w = 0
        b = 0
        for x in range(i,i+8):
            for y in range(j,j+8):
                if (x+y) % 2 == 0:
                    if board[x][y] == 'B':
                        w += 1
                    else:  # W일 경우
                        b += 1
                else:  # 홀수인 경우
                    if board[x][y] == 'B':
                        b += 1
                    else:  # W일 경우
                        w += 1
        T.append(w)
        T.append(b)
print(min(T))