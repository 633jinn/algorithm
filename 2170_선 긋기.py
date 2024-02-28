import sys

input = sys.stdin.readline

check = False
N = int(input())d
result = []
for i in range(N):
    x, y = map(int, input().split())
    a = min(x, y)
    b = max(x, y)
    if i == 0:
        result.append([a, b])
    else:
        for j in range(len(result)):
            check = False
            if a > result[j][1] or b < result[j][0]:
                check = True
            else:
                # if a<=result[j][0] and b>=result[j][1]   :
                #     result.remove([result[j][0],result[j][1]])
                    # if [a,b] not in result:
                    # result.append([a,b])
                # else:
                    if a < result[j][0]:
                        result[j][0] = a
                    if b > result[j][1]:
                        result[j][1] = b
        if check:
            result.append([a, b])

point = []
x = result[0][0]
y = result[0][1]
point.append([x,y])
value = y-x
for m in result:
    if [m[0],m[1]] not in point:
        point.append(m)
        value += m[1] - m[0]
print(value)
