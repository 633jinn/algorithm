import sys
input = sys.stdin.readline

N=[int(input()) for x in range(int(input()))]
N.sort()
for x in N:
    print(x)