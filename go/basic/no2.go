package main

import "fmt"

func main() {
    var n int

    fmt.Scanf("%d", &n) // 调用 Scanf 函数输入 n

    var sum int = 0

    for i := 1; i <= n; i++ {
        sum = sum + i
    }

    fmt.Println(sum)
}
