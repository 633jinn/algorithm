import sys

input = sys.stdin.readline

#답안 보고 품 ㅠㅠ
n, h = map(int, input().split())
up = [0] * (h + 1)
down = [0] * (h + 1)
for i in range(n):
    if i % 2 == 0:  # 석순
        down[int(input())] += 1
    else:  # 종유석
        up[int(input())] += 1

for i in range(h-1, 0,-1):
    up[i] = up[i+1]+up[i]
    down[i] = down[i+1]+down[i]

min_num = sys.maxsize
min_count = 0
for i in range(1, h+1):
    num = down[i] + up[h-i+1]
    if min_num > num:
        min_num = num
        min_count = 1
    elif min_num == num:
        min_count +=1

print(min_num, min_count)