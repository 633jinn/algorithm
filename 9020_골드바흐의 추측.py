import sys

input = sys.stdin.readline

N = 10 ** 4
arr = [True for i in range(N + 1)]
arr[0], arr[1] = False, False

for i in range(2, int(N ** 0.5) + 1):
    if arr[i]:
        for j in range(i * 2, N + 1, i):
            arr[j] = False

for i in range(int(input())):
    n = int(input())
    lst = []
    for j in range(2, int(n / 2) + 1):
        if arr[n - j] and arr[j]:
            lst.append(j)
    res = lst[0]
    for x in lst:
        if n-x*2<n-res*2:
            res=x
    print(res, n-res)