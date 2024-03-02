import itertools
import sys

input = sys.stdin.readline

N = int(input())
num = list(map(int,input().split()))
arr = [0 for _ in range(sum(num))]
num.sort()
for i in range(N):
    combi = list(itertools.combinations(num, i+1))
    for j in range(len(combi)):
        arr[sum(combi[j])-1] = 1

if 0 in arr:
    print(arr.index(0)+1)
else:
    print(len(arr)+1)

