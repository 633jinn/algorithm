import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
result = lst.copy()
for i in range(1, len(lst)):
    if result[i]<result[i-1]+lst[i]:
        result[i] = result[i-1]+lst[i]

print(max(result))