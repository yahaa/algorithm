package main

import (
    "fmt"
    "time"
)

func main() {
    var nt int64
    nt = 1537961077609424050
    mt := time.Now().Unix()
    fmt.Println(nt)
    fmt.Println(mt)

    t := time.Unix(nt/1e9, 0).Zone()


    fmt.Println(t)
    fmt.Println(t.Hour())
    fmt.Println(t.Minute())


}
