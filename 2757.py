import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = map(lambda x:x.rstrip(), sys.stdin)

import re

for v in S:
    a, b = map(int, re.findall('[A-Z]([0-9])', v))
    print(a, b)


result = re.sub(r"(?P<year>\d{4})-(?P<month>\d{2})-(?P<day>\d{2})",
                r"Year:\g<year> Month:\g<month> Day:\g<day>",
                "1977-07-25")
print(result)