import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

A, B = map(lambda x:x.rstrip(), input().split())

def find(A, B):
    for i in range(len(A)):
        for j in range(len(B)):
            if A[i] == B[j]:
                return j, i

y, x = find(A, B) # 처음으로 겹치는 부분의 좌표를 찾아서 리턴

board = ['.'*len(A) for _ in range(len(B))]
board[y] = A
board = list(zip(*board)) # y=x 대칭
board[x] = B
board = zip(*board) # y=x 대칭 (다시 원래대로)

print(*[''.join(v) for v in board], sep='\n') # 문자열로 출력