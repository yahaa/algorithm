package main

import (
    "fmt"
    "log"
    "net"
    "net/http"
    "os"
    "time"
)

func handler(w http.ResponseWriter, r *http.Request) {
    log.Printf("from %s", r.RemoteAddr)
    w.Write([]byte(fmt.Sprintf("hello server is alive %s from %s \n\n", time.Now(), hostIP())))
}

func hostIP() string {
    addr, err := net.InterfaceAddrs()
    if err != nil {
        fmt.Println(err)
        os.Exit(1)
    }
    for _, address := range addr {
        if ip, ok := address.(*net.IPNet); ok && !ip.IP.IsLoopback() {
            if ip.IP.To4() != nil {
                return ip.IP.String()
            }
        }
    }
    return ""
}

func main() {
    http.HandleFunc("/svc", handler)
    if err := http.ListenAndServe("0.0.0.0:8080", nil); err != nil {
        log.Printf(err.Error())
    }
}
