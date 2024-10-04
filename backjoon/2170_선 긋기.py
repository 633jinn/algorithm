import sys

input = sys.stdin.readline

check = False
N = int(input())
arr = list()
for i in range(N):
    arr.append(tuple(map(int, input().split())))  # x, y값들을 빠르게 받기 위해 tuple로 append

arr.sort()

start = arr[0][0]
end = arr[0][1]
answer = 0
for i in arr:
    if i[1] <= end:
        continue
    elif i[0] <= end < i[1]:
        end = i[1]
    elif end < i[0]:
        answer += end - start
        start = i[0]
        end = i[1]

answer += end - start
print(answer)
