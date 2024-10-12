import sys

input = sys.stdin.readline

x = int(input())
step = [0]

for i in range(x): # 계단의 값
    step.append(int(input()))

lst = [0 for i in range(x+1)]

for i in range(1,x+1):
    if i == 1:
        lst[1] = step[1]
    elif i == 2:
        lst[2] = step[1] + step[2]
    elif i == 3:
        lst[3] = max(step[1] + step[3], step[2] + step[3])
    else:
        lst[i] = max(lst[i-2], lst[i-3]+step[i-1])+step[i]

print(lst[x])