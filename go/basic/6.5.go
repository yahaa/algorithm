package main

import "fmt"

type User1 struct {
    Username string
    Password string
    Phone    string
    Email    string
    Nickname string
}

func main() {
    user1 := User1{
        Username: "xiaomizhou",
        Password: "123456",
        Phone:    "1888888",
        Email:    "xmz@xiaomizhou.com",
        Nickname: "mimizhou",
    }

    user2 := User1{
        Username: "zihua",
        Password: "666666",
        Phone:    "1888686",
        Email:    "zihua@xiaomizhou.com",
        Nickname: "hahaha",
    }

    fmt.Println(user1, user2)


}
