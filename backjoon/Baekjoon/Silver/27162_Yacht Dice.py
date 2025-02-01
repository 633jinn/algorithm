import sys
input=sys.stdin.readline
from collections import defaultdict

yacht=[x for x in input().rstrip()]
point=list(0 for i in range(12))
dic=defaultdict(int)
a=list(map(int, input().split()))
for i in a:
    dic[i]+=1
for i in range(11,-1,-1):
    if yacht[i]=='N':
        continue
    elif i==11: #Choice
        point[i]=sum(a)+6+6
    elif i==10: #Yacht
        if 3 in dic.values():
            point[i]=50
    elif i==9: #Big straight
        check=1
        for j in dic.keys():
            if((j>6 or j<2) or dic[j]!=1):
                check=0
                break;
        if check==1:
            point[i] = 30
    elif i==8: #Little Straight
        check = 1
        for j in dic.keys():
            if (j > 5 or dic[j] != 1):
                check = 0
                break;
        if check == 1:
            point[i] = 30
    elif i==7: #Full House
        if 3 in dic.values():
            if 6 in dic.keys():
                point[i] = 6*3+5*2
            else:
                point[i] = max(dic.keys())*3+12
        elif 2 in dic.values():
            point[i]=max(dic.keys())*3+min(dic.keys())*2
            # num=0
            # for t in dic.keys():
            #     if 1 == dic[t]:
            #         num+=t*3
            #     else:
            #         num+=t*2
            # point[i]=num
    elif i==6: #Four of a Kind
        for t in dic.keys():
            if dic[t]==2 or dic[t]==3:
                point[i]=t*4
                break
    else: #Ones ~ Sixes
        if yacht[i] == 'Y':
            point[i] = (dic[i + 1]+2) * (i + 1)

print(max(point))