data = open("input.txt", 'r').readlines()

import sys
right_stack = []
left_stack = []
#fist_str = sys.stdin.readline()
fist_str = data[0].strip();
print(fist_str)
for i in fist_str:
    left_stack.append(i)
print(left_stack)
#left_stack.pop()
#roof = int(sys.stdin.readline())
roof = int(data[1].strip())

for i in range(0, roof):
    #command = sys.stdin.readline()
    command = data[i+2].strip()
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
    else:
        left_stack.append(command[2])

print("".join(left_stack+right_stack))
