import sys
from collections import deque
#1966
a=int(sys.stdin.readline())
for i in range(a):
    n, m=map(int, sys.stdin.readline().split())
    que=deque(map(int,sys.stdin.readline().split()))
    dic={}
    for j in que:
        dic[j]=que.count(j)
        
    count=1
    while que:
        x=que.popleft()
        m-=1
        if x<max(dic.keys()):
            que.append(x)
            if(m==-1):
                m=len(que)-1
        elif m==-1:
            print(count)
            break
        else:
            if dic.get(x)==1:
                del dic[x]
            else:
                dic.update({x:que.count(x)}) 
            count+=1
        