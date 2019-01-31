package main

import (
    "fmt"
    "unsafe"
    "reflect"
)

func main() {
    var n int64 = 5
    var pn = &n
    fmt.Println(&n)
    fmt.Println(unsafe.Pointer(pn))

    pf := (*float64)(unsafe.Pointer(pn))
    // now, pn and pf are pointing at the same memory address
    fmt.Println(*pf) // 2.5e-323
    *pf = 3.14159
    fmt.Println(n) // 4614256650576692846

    var f = 10

    k := (float64)(f)
    fmt.Println(k)
    fmt.Println(reflect.TypeOf(pf))

    var i interface{} = "kk"
    j, ok := i.(int)
    fmt.Printf("%T->%d\n", j, ok)

    t := map[string]string{
        "a": "123456",
        "b": "456789",
    }
    fmt.Printf("%#v\n", t)

    kk := &t

    delete(*kk, "a")
    fmt.Printf("%#v\n", t)
    fmt.Printf("%#v\n", kk)

}
