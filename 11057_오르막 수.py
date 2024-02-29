import sys
input = sys.stdin.readline

N = int(input())
arr = [1 for _ in range(10)]
count = []
if N == 1:
    print(10)
else:
    for i in range(2,N+1):
        count = [0 for _ in range(10)]
        for j in range(9,-1,-1):
            if j == 9:
                count[j] = 1
            else:
                count[j] = sum(arr[j:])
        arr = count
    print(sum(arr)%10007)