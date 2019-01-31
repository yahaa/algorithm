package main

import (
    "index/suffixarray"
    "fmt"
    "time"
)

func te() {
    for i := 0; i < 1000; i++ {
        time.Sleep(time.Second)
        fmt.Println(i)
    }
}

func main() {
    // 创建数据的索引

    d := "aabaaaab"
    index := suffixarray.New([]byte(d))

    //fmt.Printf("")
    // 查找切片s
    a := "a"
    offsets1 := index.Lookup([]byte(a), -1) // 返回data中所有s出现的位置
    //offsets2 := index.Lookup(s, 3)  // 返回data中最多3个所有s出现的位置
    fmt.Println(offsets1)

    go te()

    for i := 0; i < 100; i++ {
        time.Sleep(time.Second)
        fmt.Println("Main")
    }

}
