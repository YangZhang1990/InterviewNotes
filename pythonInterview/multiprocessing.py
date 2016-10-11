from multiprocessing import Process
import os

def run_proc(name):
	print 'Run child process %s (%s)...' % (name,os.getpid())