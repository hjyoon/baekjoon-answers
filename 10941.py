import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import base64
print(base64.b16decode(input()).decode('utf-8'))