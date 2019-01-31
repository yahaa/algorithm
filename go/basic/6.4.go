package main

import "fmt"

func main() {
    var n int
    fmt.Scanf("%d", &n)
    h := n / 3600
    if h > 0 {
        n -= h * 3600
    }

    m := n / 60

    if m > 0 {
        n -= m * 60
    }

    s := n

    fmt.Printf("%dh/%dm/%ds", h, m, s)
}
