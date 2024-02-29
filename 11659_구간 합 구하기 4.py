import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
sumArr = [0 for i in range(N + 1)]
for i in range(1, N + 1):
    sumArr[i] = sumArr[i - 1] + arr[i - 1]
for i in range(M):
    i, j = map(int, input().split())
    print(sumArr[j] - sumArr[i - 1])