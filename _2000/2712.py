T = int(input())
for _ in range(T):
    v, u = input().split(); v = float(v)
    if u == 'kg':
        print(f'{v*2.2046:.4f} lb')
    elif u == 'l':
        print(f'{v*0.2642:.4f} g')
    elif u == 'lb':
        print(f'{v*0.4536:.4f} kg')
    else:
        print(f'{v*3.7854:.4f} l')