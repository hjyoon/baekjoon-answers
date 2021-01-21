# data = open("input.txt", 'r').readlines()
# testcase = data[0].strip()
testcase = input()

testcase = int(testcase)
score = []

for i in range(1, testcase+1):
	avg = 0         #루트 돌때마다 0으로 초기화
	percent = 0      #루트 돌때마다 0으로 초기화
	num = input().split(' ')
	# num = data[i].strip().split(' ')
	   
	for k in range(0, int(num[0])):      #평균값 구하기
		avg += int(num[k+1])

	avg /= int(num[0])

	for w in range(0, int(num[0])):      #평균보다 낮은 사람 수 구하기
		if int(num[w+1]) > avg:
			percent += 1

	score.append(round(percent/int(num[0])*100, 3))   #백분율 구하기

for i in range(0, testcase):
	print("%.3f%%" % score[i])