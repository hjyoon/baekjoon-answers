import sys


def solve():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    M = int(input())
    B = list(map(int, input().split()))

    def get_largest_common_value(l1, l2):
        common_elements = set(l1) & set(l2)
        if not common_elements:
            return None, None, None
        largest_value = max(common_elements)
        i_l1 = l1.index(largest_value)
        i_l2 = l2.index(largest_value)
        return largest_value, i_l1, i_l2

    ans = []
    start1, start2 = -1, -1
    while True:
        tmp, start1, start2 = get_largest_common_value(A, B)
        if tmp == None:
            break
        A = A[start1 + 1 :]
        B = B[start2 + 1 :]
        ans.append(tmp)

    print(len(ans))
    if len(ans) != 0:
        print(*ans)


solve()
