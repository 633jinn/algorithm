button = [300, 60, 10]
count = [0, 0, 0]
time = int(input())
res = 0
for i in range(3):
    count[i] = time // button[i]
    time = time - count[i] * button[i]
if time > 0:
    print("-1")
else:
    for i in range(3):
        print(count[i], end=' ')