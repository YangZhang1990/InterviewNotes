from wsgiref.simple_server import make_server
from hello import application

#create a server, IP is null, port is 8000,deal with function application
httpd = make_server('',8000,application)
print 'Serving HTTP on port 8000...'
#start listen to HTTP request

httpd.serve_forever()
