import sys

input = sys.stdin.readline

N = 10 ** 7
arr = [True for _ in range(N + 1)]
n = int(N ** 0.5) + 1
arr[0], arr[1] = False, False

Prime=[]
for i in range(2, N + 1):
    if arr[i]:
        Prime.append(i)
        for j in range(i * 2, N + 1, i):
            arr[j] = False

n=int(input())
print(Prime[n-1])