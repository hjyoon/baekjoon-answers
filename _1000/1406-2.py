import sys
right_stack = []
left_stack = []
fist_str = sys.stdin.readline().rstrip()
#fist_str = input()
for i in fist_str:
    left_stack.append(i)
roof = int(sys.stdin.readline())
#roof = int(input())

for i in range(0, roof):
    command = sys.stdin.readline()
    #command = input()
    if command[0] == 'L':
        if not left_stack:
            continue
        else:
            right_stack.append(left_stack.pop())
    elif command[0] == 'D':
        if not right_stack:
            continue
        else:
            left_stack.append(right_stack.pop())
    elif command[0] == 'B':
        if not left_stack:
            continue
        else:
            left_stack.pop()
    elif command[0] == 'P':
        left_stack.append(command[2])
    else:
        pass

#right_stack.reverse()
print("".join(left_stack+right_stack))
