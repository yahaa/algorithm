package main

import (
    "fmt"
)

var (
    s uint = 2
)

type D struct {
    U string
}

func Hello() []byte {
    return nil

}

type Param map[string]interface{}

type Show struct {
    Param
}

type student struct {
    Name string
}

func zhoujielun(v interface{}) {
    switch msg := v.(type) {
    case *student, student:
        fmt.Println(msg)
    }
}

type People struct {
    Name string
}

func (p *People) String() string {
    return fmt.Sprintf("print: %v", p)
}

type Student struct {
    name string
}

func main() {
    m := map[string]Student{"people": {"zhoujielun"}}
    t := m["people"]
    t.name = "alksdjf"
    fmt.Println(m)

}
