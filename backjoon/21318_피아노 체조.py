import sys

input = sys.stdin.readline


n = int(input())
sheets = list(map(int, input().split()))
q = int(input())
count = [0]*(n)
count[0] = 0
for i in range(n-1):
    if sheets[i]<=sheets[i+1] or i == n-1:
        count[i+1] = count[i]
    else:
        count[i+1]=count[i]+1

for i in range(q):
    x, y = map(int, input().split())
    print(count[y-1]-count[x-1])