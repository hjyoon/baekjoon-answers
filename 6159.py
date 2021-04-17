import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

N, S = map(int, input().rstrip().split())
A = collections.deque(sorted(map(int, sys.stdin)))

c = 0
i = 0
while True:
    if len(A) == 0:
        break
    left = 0
    right = len(A) - 1
    mid = 0
    res = 0
    def chk():
        if A[mid] + A[0] > S:
            return True
        else:
            return False
    #print(A)
    while left <= right:
        mid = (left + right) // 2
        # if m_list[mid] == target: # 파라메트릭 서치인 경우, 이분탐색을 모두 시도해본 결과가 정답이다.(물론 예외는 있음) (단순 해당 인덱스의 정답이 아닌, 가능한 경우의 최대 또는 최소를 찾는 것이기 때문에.)
        #     break
        if chk():   # 파라메트릭 서치인 경우, 조건의 참 거짓 유무를 밝히는 것이 복잡할 수 있으므로, 함수로 빼는것이 좋다.
            right = mid - 1
            # res = mid # 특정 조건을 만족할때만 정답을 업데이트 하는 경우
        else :
            left = mid + 1
            res = mid
    c += res
    #print(res, c)
    A.popleft()
print(c)