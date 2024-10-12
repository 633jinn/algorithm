import sys
#9012
a = int(sys.stdin.readline())
lst=[]
for i in range(a):
    lst.append(sys.stdin.readline().strip())

for i in lst:
    dic={'(':0, ')':0}
    for j in i:
        if (dic['(']==0 and j==')') or dic[')']>dic['(']:
            dic[j]
            break
        else:
            dic[j]+=1
    if dic['('] == dic[')']!=0:
        print('YES')
    else:
        print('NO')
#while '()' in v:
#    v = v.replace('()', '')으로 길이 줄일 수 있음.    