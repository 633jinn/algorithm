import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = [0] + list(map(int, input().split()))
window = sum(arr[1:K + 1])
res = window
for i in range(1, N - K + 1):
    window = window - arr[i] + arr[i + K]
    res = max(window, res)

print(res)
