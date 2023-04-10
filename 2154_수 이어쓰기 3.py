import sys
input = sys.stdin.readline

length=input().rstrip()
string=''
x=0;
for i in range(1, int(length)+1):
    string+=str(i)
for i in range(len(string)-len(length)+1):
    if(string[x:x+len(length)]==length):
        break
    else:
        x+=1
print(x+1)