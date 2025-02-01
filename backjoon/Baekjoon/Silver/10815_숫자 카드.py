import sys

input = sys.stdin.readline

N = int(input())  # 가지고 있는 카드
have_card = list(map(int, input().split()))
have_card.sort()
start = 0
end = len(have_card)
M = int(input())  # 있는지 체크할 카드
check_card = list(map(int, input().split()))
num = 0
result = []
while True:
    i = check_card[num]
    mid = (start + end) // 2

    if have_card[mid] == i:
        result.append(1)
        start = 0
        end = len(have_card)
        num+=1
    elif have_card[mid] > i:
        end = mid
    else:
        start = mid + 1

    if start == end:
        result.append(0)
        start = 0
        end = len(have_card)
        num+=1
    if num == len(check_card):
        break

print(*result, sep=" ")
