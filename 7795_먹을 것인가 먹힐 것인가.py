import sys

input = sys.stdin.readline

T = int(input())
start = 0
end = 0
count = 0


def bigger(A, B, lstA, lstB):
    global count
    for i in range(A):
        for j in range(B):
            if lstB[j] < lstA[i]:
                count += 1
            else:
                break


for _ in range(T):
    count = 0
    A, B = map(int, input().split())
    listA = list(map(int, input().split()))
    listB = list(map(int, input().split()))
    bigger(A, B, listA, sorted(listB))
    print(count)
