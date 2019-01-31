package main

import (
    "fmt"
    "sync"
)

func main() {
    ch := make(chan int, 100)

    for i := 0; i < 100; i++ {
        ch <- i
    }
    close(ch)
    fmt.Println("now i close the channel")

    wg := &sync.WaitGroup{}
    wg.Add(1)
    go func(w *sync.WaitGroup) {
        defer w.Done()
        for v := range ch {
            fmt.Println(v)
        }
    }(wg)

    wg.Wait()
}
