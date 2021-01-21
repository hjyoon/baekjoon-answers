data = open("input.txt", 'r').readlines()
N = data[0].strip()
#N = input()
different = 0
change = '0'
count = 0

for i in range(1, int(N)+1):
	if i < 100:
		count += 1
	else:
		change = str(i)
		different = int(change[1]) - int(change[0])
		print("i=", i, "different=", different, "\n")
		
		for k in range(0, len(change)-1):
			if different != (int(change[k+1]) - int(change[k])):
				different = '0'
				print("i=", i, "different=", different, "\n")
				
		if different != '0':
			count += 1
			print("i=", i, " count=", count)
print(count)