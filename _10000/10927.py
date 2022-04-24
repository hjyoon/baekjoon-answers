import hashlib
m=hashlib.new('md5')
txt = input()
m.update(txt.encode('utf-8'))
print(m.hexdigest())