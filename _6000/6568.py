from time import sleep
from collections import deque
from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

S = [None]
M = {}
AC = 0

for _ in range(32):
    S.append(input().rstrip())

pc = 1
while pc <= 32:
    s = S[pc]
    operation, operand = s[:3], s[3:]
    if operation == '000':  # 메모리 주소에 가산기 값을 저장
        M[operand] = AC
    elif operation == '001':  # 메모리 주소 x의 값을 가산기로 로드
        AC = M.get(operand, 0)
    elif operation == '010':  # 가산기 값이 0이면 PC값을 X로 바꾼다
        if AC == 0:
            print(operation, operand, AC, M, pc)
            sleep(1)
            pc = int(operand, 2)
            continue
    elif operation == '011':  # 아무 연산도 하지 않음
        pass
    elif operation == '100':  # 가산기 값을 1 감소
        AC -= 1
    elif operation == '101':  # 가산기 값을 1 증가
        AC += 1
    elif operation == '110':  # pc값을 X로 바꾼다
        print(operation, operand, AC, M, pc)
        sleep(1)
        pc = int(operand, 2)
        continue
    elif operation == '111':  # 프로그램 종료
        print(AC)

    print(operation, operand, AC, M, pc)
    sleep(1)

    pc += 1

print(AC)
