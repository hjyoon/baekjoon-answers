import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

# m <= 맥박 <= M
# 운동 -> +T
# 휴식 -> -R
# 초기맥박 -> m

N, m, M, T, R = map(int, input().split())

if m+T > M: # 운동 불가능
    print(-1)
    exit()

time = 0
work = 0
X = m # 초기맥박
while work != N:
    tmpX = X + T # 운동 했다고 가정한 맥박
    if m <= tmpX <= M: # 운동
        X = tmpX
        work += 1
    else: # 휴식
        X = max(X-R, m) # 맥박은 m보다 낮아지면 안됨. X-R이 m보다 작으면 맥박은 m이 됨
    time += 1
print(time)