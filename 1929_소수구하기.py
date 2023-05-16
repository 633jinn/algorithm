import sys

input = sys.stdin.readline

start, end = map(int, input().split())
lst = [True for i in range(end + 1)]
lst[0], lst[1] = False, False

for i in range(2, int(end**0.5)+1):
    if lst[i]:
        for j in range(i*2, end+1,i):
            lst[j]=False

for i in range(start, end+1):
    if lst[i]:
        print(i)