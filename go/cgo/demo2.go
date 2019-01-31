package main

/*
#cgo CFLAGS: -I/usr/local/include
#cgo LDFLAGS: -L/usr/local/bin -lhello
#include "hello.h"
 */
import "C"
import "time"

func main() {
    C.hello(C.CString("hello world"))
    time.Sleep(time.Second*5)
}
