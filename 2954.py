import sys
sys.stdin = open("input.txt", 'r')

print(sys.stdin.readline().replace('apa', 'a').replace('epe', 'e').replace('ipi', 'i').replace('opo', 'o').replace('upu', 'u'))