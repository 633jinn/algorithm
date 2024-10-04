import sys

input = sys.stdin.readline

n, m = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]


def prefix_sum(n):  # 누적 합
    global arr
    prefix_arr = [[0] * (n + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            prefix_arr[i][j] = prefix_arr[i][j - 1] + prefix_arr[i - 1][j] - prefix_arr[i - 1][j - 1] + arr[i - 1][
                j - 1]
    return prefix_arr


prefix = prefix_sum(n)

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    x1, y1= map(lambda x: x - 1, (x1, y1))
    total = prefix[x2][y2] - prefix[x2][y1] - prefix[x1][y2] + prefix[x1][y1]

    print(total)
