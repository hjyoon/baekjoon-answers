import sys
sys.stdin = open("input.txt", 'r')

hh1, mm1, ss1 = map(int, input().split(':'))
hh2, mm2, ss2 = map(int, input().split(':'))

total_ss1 = hh1*3600 + mm1*60 + ss1
total_ss2 = hh2*3600 + mm2*60 + ss2

if total_ss1 > total_ss2:
    total_ss2 += 86400

res = total_ss2 - total_ss1

print(f'{res//3600:#02d}:{res%3600//60:#02d}:{res%3600%60:#02d}')