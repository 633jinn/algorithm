import sys
import math

input = sys.stdin.readline


k, n = map(int, input().split())

line = list(int(input()) for _ in range(k))
max_size = 0
def cutting():
    global max_size
    left = 0
    right = max(line)
    while left<=right:
        mid = math.ceil((left+right)/2)
        count = 0
        for l in line:
            count += l//mid
        if count<n:
            right = mid-1
        else:
            left = mid+1
            max_size = max(mid, max_size)


cutting()

print(max_size)