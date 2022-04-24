import hashlib
m=hashlib.new('sha512')
txt = input()
m.update(txt.encode('utf-8'))
print(m.hexdigest())