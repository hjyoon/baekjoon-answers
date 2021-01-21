data = open("input.txt", 'r').readlines()
num = data[0].strip()
#num = input()
cnt = 0

for i in range(0, int(num)):
    cnt = 0
    #stack_VPS = input()
    stack_VPS = data[i+1].strip()

    for j in range(0, len(stack_VPS)):
        if stack_VPS[j] == '(':
            cnt+=1
        elif stack_VPS[j] == ')':
            cnt-=1
        if cnt == -1:
            break

    if cnt == 0:
        print("YES")
    else:
        print("NO")