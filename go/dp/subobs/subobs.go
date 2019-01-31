package main

import (
    "fmt"
    "math/rand"
    "sync"
    "time"
)

type Observer interface {
    Update(data ...interface{})
}

type Subject interface {
    RegisterObserver(obs Observer)
    RemoveObserver(obs Observer)
    NotifyObserver()
}

type WeatherData struct {
    observers   []Observer
    temperature int64
    humidity    int64
    pressure    int64
}

func NewWeatherData(t, h, p int64) *WeatherData {
    return &WeatherData{
        temperature: t,
        humidity:    h,
        pressure:    p,
    }
}

func (w *WeatherData) RegisterObserver(obs Observer) {
    w.observers = append(w.observers, obs)
}

func (w *WeatherData) RemoveObserver(obs Observer) {
    for i, v := range w.observers {
        if obs == v {
            w.observers = append(w.observers[:i], w.observers[i+1:]...)
        }
    }
}

func (w *WeatherData) NotifyObserver() {
    for _, obs := range w.observers {
        obs.Update(w.temperature, w.humidity, w.pressure)
    }
}

type ConditionDisplay struct {
    name string
    sub  Subject
}

func NewCondition(sub Subject, name string) *ConditionDisplay {
    c := &ConditionDisplay{
        sub:  sub,
        name: name,
    }
    sub.RegisterObserver(c)

    return c
}

func (c ConditionDisplay) Update(data ...interface{}) {
    fmt.Println(data, c.name)
}

func (c ConditionDisplay) Display() {
    fmt.Println(c.name, "i am display now")
}

var (
    weather *WeatherData
)

func main() {
    weather = NewWeatherData(100, 200, 10)
    wg := &sync.WaitGroup{}
    wg.Add(1)

    go func(wg *sync.WaitGroup) {
        defer wg.Done()
        for i := 0; i < 100; i++ {
            time.Sleep(time.Second)
            weather.temperature = rand.Int63n(200)
            weather.humidity = rand.Int63n(200)
            weather.pressure = rand.Int63n(200)
            weather.NotifyObserver()
        }
    }(wg)

    c1 := NewCondition(weather, "c1")
    c2 := NewCondition(weather, "c2")
    c3 := NewCondition(weather, "c3")

    c1.Display()
    c2.Display()
    c3.Display()

    wg.Wait()

}
