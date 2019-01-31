package main

import "fmt"

func main() {
    var n int
    fmt.Scanf("%d", &n)

    t := n % 5

    if t >= 1 && t <= 3 { // 如果是 第一天到第三天
        fmt.Println("Fishing")
    } else {
        fmt.Println("Drying")
    }
}
