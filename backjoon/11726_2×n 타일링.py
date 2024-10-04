import sys
input = sys.stdin.readline


n = int(input())
lst = [0]*(n+1)

for i in range(n+1):
    if i == 1:
        lst[1] = 1
    elif i == 2:
        lst[2] = 2
    else:
        lst[i] = lst[i-1] + lst[i-2]

print(lst[n]%10007)