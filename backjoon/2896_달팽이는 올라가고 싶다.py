import sys

input = sys.stdin.readline

A, B, V = map(int, input().split())

a, b = divmod(V - A, A - B)
if b != 0:
    a += 1
    
print(a+1)
