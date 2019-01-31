package main

import (
    "fmt"
    "time"
)

func main() {
    co := make(chan int)
    ch := make(chan int, 100)

    go send(ch)

    go rev(ch, co)

    <-co

}

func send(ch chan int) {
    for i := 0; i < 10000; i++ {
        ch <- i
        fmt.Printf("I'm sender send %v \n", i)
        //time.Sleep(time.Second * 3)
    }

    fmt.Println("I'm finished")

}

func rev(ch, co chan int) {
    for {
        re := <-ch
        fmt.Println(re)
        time.Sleep(time.Second / 1000)
    }
    close(co)
}
