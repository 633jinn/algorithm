import sys
import bisect
a= [50, 60, 70]
x=60

print(bisect.bisect_right(a, x))
card_size = int(sys.stdin.readline())
card = list(map(int, sys.stdin.readline().split()))
own_card_size = int(sys.stdin.readline())
own_card = list(map(int, sys.stdin.readline().split()))
start=0
end=card_size-1
card_dic={}

for i in card:
    if i in card_dic :
        card_dic[i]+=1;
    else:
        card_dic[i]=1
for i in own_card:
    if i in card_dic :
        print(card_dic[i])
    else:
        print(0)
        