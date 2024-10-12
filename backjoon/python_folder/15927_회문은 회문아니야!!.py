import sys
input = sys.stdin.readline

string = list(input().rstrip())
count = 0
check = False
if string.count(string[0]) == len(string):
    print("-1")
else:
    left = 0
    right = len(string)-1
    flag = False #회문이 아니면 True
    while left<right:
        if string[left] != string[right]:
            flag = True
            break
        left = left + 1
        right = right - 1
    if flag:
        print(len(string))
    else:
        print(len(string)-1)
