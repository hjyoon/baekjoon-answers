import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

birth_year, birth_month, birth_day = map(int, input().split())
year, month, day = map(int, input().split())

if birth_month == month:
    if birth_day > day:
        print(year - birth_year - 1)
    else:
        print(year - birth_year)
elif birth_month > month:
    print(year - birth_year - 1)
else:
    print(year - birth_year)

print(year - birth_year + 1)
print(year - birth_year)