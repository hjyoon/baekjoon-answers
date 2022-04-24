import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

t = ("", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh")
tt = ("", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh")

_, *S = map(lambda x:x.rstrip(), sys.stdin)
for i, v in enumerate(S):
    a, b = sorted(map(int, v.split()), reverse=True)
    if a == b:
        print(f'Case {i+1}: {tt[a]}')
    else:
        if a == 6 and b == 5:
            print(f'Case {i+1}: {t[a]} Beesh')
        else:
            print(f'Case {i+1}: {t[a]} {t[b]}')