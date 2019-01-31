package main

import (
    "fmt"
    "html/template"
    "net/http"
    "time"
)

type User struct {
    Name     string
    Pass     string
    Money    []string
    Birthday time.Time
}

func fDate(d time.Time) int64 {
    return d.UnixNano()
}

func handler2(w http.ResponseWriter, r *http.Request) {
    //w.Header().Set("X-XSS-Protection", "0")
    //funcMap := template.FuncMap{"fdate": fDate}
    //t := template.New("gofoer").Funcs(funcMap)
    //t = template.Must(t.ParseFiles("template/index.html", "template/layout.html"))
    //t.ExecuteTemplate(w, "layout", template.HTML(r.FormValue("comment")))
}
func handler(w http.ResponseWriter, r *http.Request) {
    w.Header().Set("X-XSS-Protection", "0")
    t, err := template.ParseFiles("template/layout.html")
    if err != nil {
        fmt.Println(err)
        return
    }
    fmt.Println(t.Name())

    t.ExecuteTemplate(w, "layout", template.HTML(r.FormValue("comment")))
}

func main() {
    //http.HandleFunc("/", handler)
    //http.ListenAndServe(":8080", nil)
    for i:=0;i<81;i++{
        fmt.Print(i,",")
    }
}
