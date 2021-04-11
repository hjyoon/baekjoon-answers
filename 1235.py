import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, *S = list(map(lambda x:x.rstrip(), sys.stdin))

left = 0 
right = len(S[0]) - 1
mid = 0

def chk():
    s = set()
    for v in S:
        s.add(v[len(S[0])-mid:])
    if len(s) == len(S):
        return True
    else:
        return False

while left <= right:
    mid = (left + right) // 2
    if chk():
        #print(mid, 'True')
        right = mid - 1
    else :
        #print(mid, 'False')
        left = mid + 1

print(mid + 1)