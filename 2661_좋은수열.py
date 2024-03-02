import sys

input = sys.stdin.readline

N = int(input())
arr = []
answer = 0


def choose(arr, length):
    for i in range(1, length):
        if str(arr)[length - 2 * i:length - i] == str(arr)[length - i:]:
            return
    if length == N:
        print(arr)
        exit(0)
    for j in range(1, 4):
        choose(arr * 10 + j, length + 1)


choose(0, 0)