import sys


def solve():
    code = sys.stdin.readline()
    w = 1 if code.find("*") % 2 == 0 else 3
    tmp = 0
    for i in range(13):
        if code[i] == "*":
            continue
        else:
            if i % 2 == 0:
                tmp += int(code[i])
            else:
                tmp += int(code[i]) * 3

    res = (10 - (tmp % 10)) % 10
    while res % w != 0:
        res += 10
    res = res // w

    print(res)


solve()
