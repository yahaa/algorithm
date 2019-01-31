package main

import "fmt"

type Pet interface {
    //SetName(name string)
    Name() string
    Category() string
}

type Dog struct {
    name string
}

func (d Dog) Name() string {
    return d.name
}

func (d Dog) Category() string {
    return "dog"
}

func (d *Dog) SetName(name string) {
    d.name = name
}

type BigDog struct {
    *Dog
    bigName string
}

func main() {
    //dog := Dog{"abc"}

    var dog1 *Dog
    dog2 := dog1

    var p Pet = dog2

    fmt.Printf("%T", p)

    if p == nil {
        fmt.Println("yes")

    } else {
        fmt.Println("no")
    }

    //p.Name()

    var bigDog BigDog
    bigDog.Dog = &Dog{"he"}
    fmt.Println(bigDog.Name())

}
