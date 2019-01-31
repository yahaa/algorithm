package main

func main() {
    var x = make(chan int, 1)
    go func() {
        x <- 1
    }()

    <-x
}
