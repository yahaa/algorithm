package main

import "fmt"

type User struct {
    username string
    password string
    car      Car
}

type Car struct {
    brandName string
    price     float64
}

func main() {
    var user1 = User{
        username: "xiaomizhou",
        password: "123456",
        car: Car{
            brandName: "baoma",
            price:     100000000,
        },
    }

    var user2 = User{
        username: "zihua",
        password: "123456",
        car: Car{
            brandName: "niuche",
            price:     10,
        },
    }

    fmt.Println(user1.username, user2.username)
    fmt.Println(user1.car, user2.car)

}
