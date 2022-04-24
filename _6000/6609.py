import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

for v in sys.stdin:
    # M,P,L은 첫째 주에 있는 모기, 번데기, 유충의 숫자
    # E는 한 모기가 낳는 알의 수
    # R과 S는 살아남는 유충과 번데기의 비율
    # N은 모기 수를 구하려는 시점(N주 후)
    M, P, L, E, R, S, N = map(int, v.split())
    m, p, l = M, P, L
    for _ in range(N):
        tmp_l = m*E
        m = p//S
        p = l//R
        l = tmp_l
    print(m)
