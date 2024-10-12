import sys

input = sys.stdin.readline

num = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']

left = 0
right = 0
string = input().strip()


def find(idx_num):
    global string
    left_num = idx_num - 1
    right_num = idx_num + 1
    while True:
        if left_num - 1 >= 0 and string[left_num - 1] in num:
            left_num -= 1
        elif left_num - 1 == 0 and string[left_num - 1] == '-':
            left_num -= 1
        else:
            break
    while True:
        if right_num + 1 < len(string) and string[right_num + 1] in num:
            right_num += 1
        else:
            break
    if string[idx_num] == '+':
        change_num = int(string[left_num:idx_num]) + int(string[idx_num + 1:right_num + 1])
    else:
        change_num = int(string[left_num:idx_num]) - int(string[idx_num + 1:right_num + 1])
    return left_num, right_num, change_num


while True:
    if '+' in string:
        idx = string.index('+')
        left, right, change = find(idx)
        if right + 1 < len(string):
            string = string[0:left] + (str(change)) + string[right + 1:]
        else:
            string = string[0:left] + str(change)
    elif '-' in string:
        second_idx = string.find('-',1)
        if second_idx == -1 and string.index('-') == 0:
            print(string) # -10과 같이 음수만 남았을 경우 종료
            break
        else:
            left, right, change = find(second_idx)
            if right + 1 < len(string):
                string = string[0:left] + (str(change)) + string[right + 1:]
            else:
                string = string[0:left] + str(change)
    else:
        print(string)
        break

