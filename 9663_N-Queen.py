import sys

input = sys.stdin.readline

N = int(input())

def dfs(row, column, visited):
    global count
    if row == N:
        count += 1
        return
    else:
        check = False
        if row != 0:
            for i in range(row):
                j = visited[i]
                if (i - j == row - column or i + j == row + column
                        or j == column):
                    check = True
                    break
        if not check: # 퀸을 놓을 수 있다면
            visited[row] = column
            if row == N- 1: # 마지막 row라면
                count += 1
                return
            else:
                dfs(row + 1, 0, visited)
        if column != N - 1:
            dfs(row, column + 1, visited)


count = 0

visited = [False] * N

dfs(0, 0, visited)
print(count)
