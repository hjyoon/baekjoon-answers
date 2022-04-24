import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import base64
print(base64.b16encode(bytes(input(), 'ascii')).decode('utf-8'))