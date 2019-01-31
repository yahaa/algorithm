package main

import (
    "time"
    "fmt"
    _ "net/http/pprof"
    "github.com/beeker1121/goque"
    "golang.org/x/net/context"
    "math"
)

var (
    queue goque.Queue
)

func init() {
    q, err := goque.OpenQueue("/Users/zihua/Desktop/qq")
    if err != nil {
        panic(err)
    }
    queue = *q

}

type User struct {
    Name     string
    Password int
}

func Worker(ctx context.Context) {
    fmt.Println("work start to work")
    duration := time.Duration(time.Second / 10)
    cron := time.NewTicker(duration)
    defer cron.Stop()

    for {
        <-cron.C
        select {
        case <-ctx.Done():
            fmt.Println("work exist now ...")
            return
        default:
            _, err := queue.EnqueueObject(User{"zihua", time.Now().Nanosecond()})
            if err != nil {
                fmt.Println(err.Error())
            }

        }
    }
}

func Consumer(ctx context.Context) {
    fmt.Println("consumer start to work")
    duration := time.Duration(time.Second / 10)
    cron := time.NewTicker(duration)
    defer cron.Stop()
    for {
        <-cron.C
        select {
        case <-ctx.Done():
            fmt.Println("consumer exist now ...")
            return
        default:
            var u User
            item, err := queue.Dequeue()
            if err != nil {
                continue
            }
            err = item.ToObject(&u)
            if err != nil {
                continue
            }
            fmt.Println(u.Name, u.Password)
        }
    }

}

func main() {

    //go func() {
    //    http.ListenAndServe("0.0.0.0:8080", nil)
    //}()
    //
    //c := make(chan os.Signal)
    //signal.Notify(c)
    //ctx, cancel := context.WithCancel(context.Background())
    //go Worker(ctx)
    ////go Consumer(ctx)
    //
    //s := <-c
    //fmt.Println(s)
    //cancel()
    fmt.Println(math.Sqrt(2))

    // normalize x

}
