import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
res=0
i,j=0,1
Sum = arr[0]
while i != N:
    if Sum < M:
        if j == N:
            break
        Sum += arr[j]
        j += 1
    elif Sum > M:
        Sum -= arr[i]
        i += 1
    else:
        res += 1
        if j == N:
            break
        Sum += arr[j]
        j += 1

print(res)
