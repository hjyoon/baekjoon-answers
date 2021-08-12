n, x = map(int, input().split())
ns = list(map(int, input().split()))

#res = [v for v in ns if v < x]
res = list(filter(lambda v:v<x, ns))
print(*res)