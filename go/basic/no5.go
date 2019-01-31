package main

import "fmt"

func main() {
    var n int
    fmt.Println("请输入一个正整数 n:")
    fmt.Scanf("%d", &n) // 输入 n
    var c = 1
    for i := 1; i <= n; i++ {
        c *= i // 让 c 累乘
    }

    fmt.Printf("%d", c)
}
