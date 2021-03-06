import sys, optparse
from proton import *

parser = optparse.OptionParser(usage="usage: %prog [options] <addr_1> ... <addr_n>",
                               description="simple message receiver")
parser.add_option("-c", "--certificate", help="path to certificate file")
parser.add_option("-k", "--private-key", help="path to private key file")
parser.add_option("-p", "--password", help="password for private key file")

opts, args = parser.parse_args()

if not args:
  args = ["amqp://localhost/test-queue.abc"]

mng = Messenger()
mng.certificate=opts.certificate
mng.private_key=opts.private_key
mng.password=opts.password
mng.start()

for a in args:
  mng.subscribe(a)
  print "subscribed to "+a

msg = Message()
while True:
  print "recv()"
  mng.recv(1)
  while mng.incoming:
    print "mgn.get()"
    try:
      mng.get(msg)
    except Exception, e:
      print e
    else:
      print msg.address, msg.subject or "(no subject)", msg.properties, msg.body

mng.stop()
