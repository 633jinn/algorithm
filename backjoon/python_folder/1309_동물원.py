import sys

input = sys.stdin.readline

n = int(input())

cage = [0, 3, 7, 17, 41]
if n>4:
    for i in range(4, n):
        cage.append((cage[i]*2+cage[i-1])%9901)
print(cage[n]%9901)