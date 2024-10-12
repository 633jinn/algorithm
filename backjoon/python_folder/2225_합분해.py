import sys

input = sys.stdin.readline

N, K = map(int, input().split())
MOD = 1000000000
# arr = [0 for i in range(N+1)]
lst = [[1 for _ in range(N + 1)] for _ in range(K + 1)]
if K > 1:
    for i in range(2, K + 1):  # 정수의 갯수
        for j in range(1, N + 1):
            lst[i][j] = sum(lst[i - 1][0:j + 1]) % MOD

print(lst[K][N] % MOD)
