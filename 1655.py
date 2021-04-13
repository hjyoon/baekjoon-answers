import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(int, sys.stdin)

import heapq

pq_max = []
pq_min = []

heapq.heapify(pq_max)
heapq.heapify(pq_min)

for v in S:
    if len(pq_max) == len(pq_min):
        heapq.heappush(pq_max, -v)
    else:
        heapq.heappush(pq_min, v)

    if len(pq_max) > 0 and len(pq_min) > 0:
        if pq_min[0] < -pq_max[0]:
            a = -heapq.heappop(pq_max)
            b = heapq.heappop(pq_min)
            heapq.heappush(pq_max, -b)
            heapq.heappush(pq_min, a)
            
    print(-pq_max[0])