package main

import (
    "fmt"
    "net"
)

func main() {
    var (
        addr = &net.UDPAddr{
            IP:   net.ParseIP("127.0.0.1"),
            Port: 9981,
        }

        users = make([]*net.UDPAddr, 0)
    )

    udpCon, err := net.ListenUDP("udp", addr)
    if err != nil {
        fmt.Println(err)
        return
    }

    fmt.Printf("Local: <%s> \n", udpCon.LocalAddr().String())

    go func() {
        for {
            var msg string
            fmt.Print(">>> ")
            fmt.Scanf("%s", &msg)
            if msg == "" {
                continue
            }

            for _, u := range users {
                _, err = udpCon.WriteToUDP([]byte(msg), u)
                if err != nil {
                    fmt.Printf(err.Error())
                }

            }
        }

    }()

    data := make([]byte, 1024)
    for {
        n, remoteAddr, err := udpCon.ReadFromUDP(data)
        if err != nil {
            fmt.Printf("error during read: %s", err)
        }

        users = append(users, remoteAddr)

        fmt.Printf("\n<recive from %s> %s\n", remoteAddr, data[:n])
    }
}
