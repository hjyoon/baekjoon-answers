import hashlib
m=hashlib.new('sha')
txt = input()
m.update(txt.encode('utf-8'))
print(m.hexdigest())