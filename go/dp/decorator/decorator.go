package main

import (
    "fmt"
)

type Beverage interface {
    Description() string
    Price() float32
}

type Decaf struct {
    name  string
    price float32
}

func (decaf Decaf) Description() string {
    return decaf.name
}

func (decaf Decaf) Price() float32 {
    return decaf.price
}

type Milk struct {
    beverage Beverage
    name     string
    price    float32
}

func (milk Milk) Description() string {
    return milk.name + " + " + milk.beverage.Description()
}

func (milk Milk) Price() float32 {
    return milk.price + milk.beverage.Price()
}

type Mocha struct {
    beverage Beverage
    name     string
    price    float32
}

func (mocha Mocha) Description() string {
    return mocha.name + " + " + mocha.beverage.Description()
}

func (mocha Mocha) Price() float32 {
    return mocha.price + mocha.beverage.Price()
}

func main() {
    var decaf Beverage
    decaf = Decaf{name: "decaf", price: 100.5}
    decaf = Milk{beverage: decaf, name: "milk", price: 24.56}
    decaf = Mocha{beverage: decaf, name: "mocha", price: 200}

    fmt.Println(decaf.Price(), decaf.Description())
}
