buy=int(input())
money=1000 - buy
change=[500, 100, 50, 10, 5, 1]
index=0
count=0
for i in range(6):
    while money >= change[i]:
        money -= change[i]
        count += 1
    if money==0:
        break
print(count)