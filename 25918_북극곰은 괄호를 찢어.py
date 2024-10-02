import sys

input = sys.stdin.readline

N = int(input())
S = list(input().strip())
day = 0
i = 0

new = list()
while S:
    if S[i] + S[i + 1] == '()' or S[i] + S[i + 1] == ')(':
        i += 2
    else:
        new.append(S[i])
        i += 1
    if i >= len(S) - 1:
        if i == len(S) - 1:
            new.append(S[i])
        if len(new) % 2 == 1:
            day = -1
            break
        i = 0
        S = new
        new = []
        day += 1

print(day)
