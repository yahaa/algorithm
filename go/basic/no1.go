package main

import "fmt"

func main() {
    var n int

    fmt.Scanf("%d", &n) // 调用 Scanf 函数输入 n

    for i := 1; i <= n; i++ {
        fmt.Printf("%d ", i)
    }
}