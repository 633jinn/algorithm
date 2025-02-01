import sys

input = sys.stdin.readline
k = int(input())
string = list(map(str, input().split()))  # 부등호 모음 리스트
min_num = ''
max_num = ''


def min(num):
    global min_num
    if num == '':
        for i in range(0, 10):
            min(str(i))
            if len(min_num) == k + 1:
                break
    else:
        last = len(num) - 1
        if last == k:
            min_num = num
            return
        if string[last] == '<':
            for i in range(int(num[last]) + 1, 10):
                if str(i) not in num:
                    min(num + str(i))
                    if len(min_num) == k + 1:
                        break

        else:
            for i in range(0, int(num[last])):
                if str(i) not in num:
                    min(num + str(i))
                    if len(min_num) == k + 1:
                        break


def max(num):
    global max_num
    if num == '':
        for i in range(9, -1, -1):
            max(str(i))
            if len(max_num) == k + 1:
                break
    else:
        last = len(num) - 1
        if last == k:
            max_num = num
            return
        if string[last] == '<':
            for i in range(9, int(num[last]), -1):
                if str(i) not in num:
                    max(num + str(i))
                    if len(max_num) == k + 1:
                        break

        else:
            for i in range(int(num[last])-1, -1, -1):
                if str(i) not in num:
                    max(num + str(i))
                    if len(max_num) == k + 1:
                        break

max('')
min('')
print(max_num)
print(min_num)
