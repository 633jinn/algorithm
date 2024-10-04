import sys

input = sys.stdin.readline
while True:
    try:
        x = int(input()) * 10000000  # 나노미터 단위
        n = int(input())  # 블럭 수
        block = []
        for _ in range(n):
            block.append(int(input()))
        block.sort()
        answer = {}
        low = 0
        high = len(block) - 1

        while True:
            if low >= high:
                break
            else:
                low_value = block[low]
                high_value = block[high]
                if low_value + high_value == x:
                    answer[high_value - low_value] = (low_value, high_value)
                    low += 1
                elif low_value + high_value > x:
                    high -= 1
                else:
                    low += 1

        if len(answer) == 0:
            print("danger")
        else:
            # answer = dict(sorted(answer.items(), reverse=True))
            value = list(answer.values())[0]
            print("yes", value[0], value[1])
    except:
        break
