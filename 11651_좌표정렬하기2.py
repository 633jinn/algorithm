import sys
input = sys.stdin.readline

arr = [tuple(map(int, input().split())) for x in range(int(input()))]
arr.sort(key=lambda x : (x[1], x[0]))
for i in arr:
    print(i[0],i[1])