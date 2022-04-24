import hashlib
m=hashlib.new('ripemd160')
txt = input()
m.update(txt.encode('utf-8'))
print(m.hexdigest())