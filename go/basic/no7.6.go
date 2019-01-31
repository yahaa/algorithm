package main

import "fmt"

func main() {
    var a = make(map[int]bool)
    // map 的 key 是一个集合，所以 map 的 key 自动带了去重功能
    var n int
    fmt.Scanf("%d", &n)
    for i := 0; i < n; i++ {
        var f int
        fmt.Scanf("%d", &f)
        a[f] = true // 这里我们只关心 f 这个数是否出现,在这里输入了 f 也就是说 f 一定出现了，所以我们把 a[f]=true
    }

    for k, v := range a {
        if v { // 如果 k 的值 v==true
            fmt.Printf("%d ", k)
        }
    }
}
