import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

res = 0
def dfs(n):
    global res
    if n > N:
        return
    dfs(n*10+7)
    dfs(n*10+4)
    res = max(res, n)

# def chk(n):
#     for v in n:
#         if v != '4' and v != '7':
#             return False
#     return True

N = int(input())
dfs(0)
print(res)