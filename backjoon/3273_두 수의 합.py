import sys

input = sys.stdin.readline
from itertools import permutations
lst = list(map(int, input().split()))
permutations(lst, )
n = int(input())
x = 0
y = len(lst)-1
result = int(input())
lst.sort()
sets = set()
sets.add()
c = 0
while x<y:
    total = lst[x] + lst[y]
    if total == result:
        c+=1
        y-=1
    elif total<total:
        y-=1
    else:
        x+=1

print(c)