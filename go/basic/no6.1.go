package main

import "fmt"

func main() {
    var n int
    fmt.Scanf("%d", &n)
    sum := 0
    for n > 0 {
        t := n % 10
        sum += t
        n /= 10
    }

    fmt.Println(sum)
}
