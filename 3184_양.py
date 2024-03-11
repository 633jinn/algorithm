import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

R, C = map(int, input().split())
arr = []
for _ in range(R):
    arr.append(list(map(str, input().rstrip())))
check = [[0 for _ in range(C)] for _ in range(R)]

all_lamb = 0
all_wolf = 0

lamb = 0
wolf = 0

def direction(arr, row, column, direct):
    global C
    if direct == 0 and column > 0 and check[row][column-1]==0:
        if arr[row][column - 1] != '#':  # 'left'
            return row, column - 1
        else:
            check[row][column - 1] = 1
            return row, column
    elif direct == 1 and column < C - 1 and check[row][column+1]==0:
        if arr[row][column + 1] != '#':  # 'right'
            return row, column + 1
        else:
            check[row][column + 1] = 1
            return row, column
    elif direct == 2 and row > 0 and check[row-1][column]==0:
        if arr[row - 1][column] != '#':  # 'top'
            return row - 1, column
        else:
            check[row - 1][column] = 1
            return row, column
    elif direct == 3 and row < R - 1 and check[row+1][column]==0:
        if arr[row + 1][column] != '#':  # 'bottom'
            return row + 1, column
        else:
            check[row + 1][column] = 1
            return row, column
    else:
        return row, column


def find_animals(row, column):
    global wolf
    global lamb
    if arr[row][column] == "o":
        lamb += 1
    elif arr[row][column] == "v":
        wolf += 1
    check[row][column] = 1
    for i in range(4):
        x, y = direction(arr, row, column, i)
        if x != row or y != column and check[x][y] == 0:
            check[x][y] = 1
            find_animals(x, y)


def find_field():
    global all_lamb
    global all_wolf
    global wolf
    global lamb
    for i in range(R):
        while True:
            if 0 in check[i]:
                lamb = 0
                wolf = 0
                idx = check[i].index(0)
                check[i][idx] = 1
                find_animals(i, idx)
                if lamb > wolf:
                    all_lamb += lamb
                else:
                    all_wolf += wolf
            else:
                break


find_field()
print(all_lamb, all_wolf)
