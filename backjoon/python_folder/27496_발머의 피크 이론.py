import sys

input = sys.stdin.readline

N, M = map(int, input().split())
alcohol = list(map(int, input().split()))
window = 0
res=0
for i in range(M):
    window += alcohol[i]
    if 0.129 <= window * 0.001 <= 0.138:
        res += 1
for i in range(M, N):
    window = window + (alcohol[i] - alcohol[i - M])
    if 0.129 <= window * 0.001 <= 0.138:
        res += 1
print(res)
