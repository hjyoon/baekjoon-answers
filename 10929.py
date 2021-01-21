import hashlib
m=hashlib.new('sha224')
txt = input()
m.update(txt.encode('utf-8'))
print(m.hexdigest())