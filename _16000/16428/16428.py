import sys

a, b= map(int, sys.stdin.readline().split())

if a >= 0 and b >= 0 :
	x, y = divmod(a,b)
	print(x, y)
elif a >= 0 and b < 0 :
	x, y = divmod(a,-b)
	print(-x, y)
elif a < 0 and b >= 0 :
	x, y = divmod(a,b)
	print(x, y)
elif a < 0 and b < 0 :
	x, y = divmod(a,-b)
	print(-x, y)