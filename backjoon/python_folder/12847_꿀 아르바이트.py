import sys

input = sys.stdin.readline

n, m = map(int, input().split())
amount = list(map(int, input().split()))
prefix = [0]*(n+1)
prefix[m] = sum(amount[0:m])
for i in range(m, n):
    prefix[i+1]=prefix[i]+amount[i]-amount[i-m]

print(max(prefix))