package main

import (
    "github.com/gen2brain/go-unarr"
    "fmt"
)

func main() {
    a, err := unarr.NewArchive("/Users/zihua/Desktop/test.rar")
    if err != nil {
        panic(err)
    }
    defer a.Close()


    list, err := a.List()
    for _, item := range list {
        fmt.Println(item)
    }
}
