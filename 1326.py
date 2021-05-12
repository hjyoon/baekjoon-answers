import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = [0]
S.extend(list(map(int, input().rstrip().split())))
A, B = map(int, input().rstrip().split())

chk = [False] * 10001

#print(N, S, A, B)

import collections

ans = -1

def bfs():
    global ans
    dq = collections.deque()
    step = 0
    dq.append((A, step))

    while len(dq) > 0:
        m = dq.popleft()
        #print(m)
        cur = m[0]
        jmp_dist = S[cur]
        step = m[1]

        if chk[cur] == True:
            continue
        else:
            chk[cur] = True

        if cur == B:
            ans = step
            break

        i = 1
        while True:
            t = cur+jmp_dist*i
            if t <= N:
                dq.append((t, step+1))
            else:
                break
            i += 1
        i = 1
        while True:
            t = cur-jmp_dist*i
            if t > 0:
                dq.append((t, step+1))
            else:
                break
            i += 1

bfs()
print(ans)