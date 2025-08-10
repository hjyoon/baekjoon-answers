import sys


def solve():
    *S, _ = sys.stdin.read().rstrip().split("\n")
    S = map(lambda x: x.split(), S)

    res = []

    for name, age, weight in S:
        res.append(
            name + " " + ("Senior" if int(age) > 17 or int(weight) >= 80 else "Junior")
        )

    print("\n".join(res))

solve()
