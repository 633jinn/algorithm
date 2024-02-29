import sys

input = sys.stdin.readline

N = int(input())
A = [0] + list(map(int, input().split()))
Sum = 0

sumOfArray = sum(A[2:N + 1])
for i in range(1, N):
    Sum = Sum + sumOfArray * A[i]
    sumOfArray -= A[i + 1]

print(Sum % 1000000007)
