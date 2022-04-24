import sys
sys.stdin = open("input.txt", 'r')

#l = eval('int(input()),'*10)
l = list(map(lambda x:int(x.strip()), sys.stdin))

print(sum(l)//10)
print(max(l, key=l.count)) # key=lambda x:l.count(x)