package main

import "fmt"

var avg float64

var sum float64

func main() {
    var n int
    fmt.Scanf("%d", &n)
    var sum = 0
    for i := 1; i <= n; i++ {
        var t int
        fmt.Scanf("%d", &t)
        sum = sum + t
    }
    avg = float64(sum / n)

    fmt.Printf("%.2f", avg)
}
