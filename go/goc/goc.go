package main

import (
    "fmt"
    "unsafe"
)

// #include <stdio.h>
// #include <stdlib.h>
/*
class Dog{
public:
    int a;
    int Dog(int a){
        printf("%d",a);
    }
};

Dog d(10);
void print(char *str) {
    int i=0;
    int n=10;
    for(i=0;i<n;i++){
        printf("%d",i);
    }
    printf("%s\n", str);
}
*/
import "C"

func main() {
    s := "Hello Cgo"
    fmt.Println(s)
    cs := C.CString(s)
    C.print(cs)
    C.free(unsafe.Pointer(cs))
}
