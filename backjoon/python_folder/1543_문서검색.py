str=input().rstrip()
find=input().rstrip()
x=0
count=0
for i in range(len(str)-len(find)+1):
    if str[x:x+len(find)]==find:
        count+=1
        x+=len(find)
    else:
        x+=1
print(count)