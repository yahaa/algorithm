package main

import (
    "fmt"
)

type FlyBehavior interface {
    Fly()
}

type QuackBehavior interface {
    Quack()
}

type Duck struct {
    flyBehavior   FlyBehavior
    quackBehavior QuackBehavior
}

func (duck *Duck) PerformFly() {
    duck.flyBehavior.Fly()
}

func (duck *Duck) PerformQuack() {
    duck.quackBehavior.Quack()
}

func (duck *Duck) Swim() {
    fmt.Println("all docks float,even decoys!")
}

type FlyWithWings struct {
}

func (f *FlyWithWings) Fly() {
    fmt.Println("i am fly with my wings now")
}

type FlyWithRock struct {
}

func (f *FlyWithRock) Fly() {
    fmt.Println("i am fly with a rock now")
}

type QuackWithMouth struct {
}

func (f *QuackWithMouth) Quack() {
    fmt.Println("i am quack with mouth now")
}

func main() {
    var (
        duck Duck
        //flyWithWings   *FlyWithWings
        quackWithMouth *QuackWithMouth
        flyWithRock    *FlyWithRock
    )

    duck.flyBehavior = flyWithRock
    duck.quackBehavior = quackWithMouth

    duck.PerformQuack()
    duck.PerformFly()

}
