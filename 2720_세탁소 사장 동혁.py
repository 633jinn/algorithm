num = int(input())
lst = [int(input()) for i in range(num)]
num*=100
change = [25, 10, 5, 1]

for i in lst:
    for j in change:
        count=i//j
        i=i%j
        print(count, end=' ')
    print(end= "\n")