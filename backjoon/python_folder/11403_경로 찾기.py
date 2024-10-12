import sys
input = sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

def floyd():

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if arr[i][k]+arr[k][j]>1:
                    arr[i][j] = 1

floyd()
for a in arr:
    print(*a)
