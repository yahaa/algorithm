package main

import (
    "fmt"
    "github.com/grafov/m3u8"
    "strconv"
    "strings"
)

// TsKeyHeap ts 文件堆（最小堆）
type TsKeyHeap []string

func (h TsKeyHeap) Len() int {
    return len(h)
}
func (h TsKeyHeap) Less(i, j int) bool {
    t1 := h.keyNano(i)
    t2 := h.keyNano(j)

    return t1 < t2
}
func (h TsKeyHeap) Swap(i, j int) {
    h[i], h[j] = h[j], h[i]
}
func (h *TsKeyHeap) Push(x interface{}) {
    key := x.(string)
    if h.verify(key) {
        *h = append(*h, key)
    }
}
func (h *TsKeyHeap) Pop() interface{} {
    var (
        old = *h
        x   interface{}
        n   = len(old)
    )

    if n > 0 {
        x = old[n-1]
        *h = old[0 : n-1]
    }

    return x
}

func (h TsKeyHeap) verify(key string) bool {
    ks := strings.Split(key, "_")
    return len(ks) == 13
}

func (h TsKeyHeap) keyNano(i int) int64 {
    ks := strings.Split(h[i], "_")
    t, err := strconv.ParseInt(ks[7], 10, 64)
    if err != nil {
        return 0
    }
    return t
}

func main() {
    //h := &TsKeyHeap{}
    //heap.Init(h)
    //heap.Push(h, "ts_shanghai_shu_good_2018-09-27_15_30_1538033449735296556_5400_1538033449735294485_1_1174624_false.ts")
    //heap.Push(h, "ts_shanghai_shu_good_2018-09-27_15_31_1538033465810478216_5400_1538033449735294485_4_1648948_false.ts")
    //heap.Push(h, "ts_shanghai_shu_good_2018-09-27_15_30_1538033455019946067_5400_1538033449735294485_2_1122548_false.ts")
    //heap.Push(h, "ts_shanghai_shu_good_2018-09-27_15_31_1538033471370402194_5400_1538033449735294485_5_1637480_false.ts")
    //heap.Push(h, "ts_shanghai_shu_good_2018-09-27_15_30_1538033455019946067_5400_1538033449735294485_2_1122548_false.ts")
    //heap.Push(h, "ts_shanghai_shu_good_2018-09-27_15_31_1538033492761687599_5400_1538033449735294485_9_1657408_false.ts")
    //heap.Push(h, "ts_shanghai_shu_good_2018-09-27_15_31_1538033481994106016_5400_1538033449735294485_7_1638796_false.ts")
    //heap.Push(h, "ts_shanghai_shu_good_2018-09-27_15_31_1538033460204464207_5400_1538033449735294485_3_1644812_false.ts")
    //for h.Len() > 0 {
    //    fmt.Printf("%v \n", h)
    //    fmt.Printf("%s \n", heap.Pop(h))
    //}
    //
    //t := time.Unix(0, 1538033449735296556)
    //t1 := time.Unix(0, 1538033460204464207)
    //fmt.Println(t, t1)

    playList, err := m3u8.NewMediaPlaylist(5, 5)



    if err != nil {
        fmt.Println(err)
        return
    }

    for i := 0; i < 100; i++ {
        if i%5 == 0 {
            fmt.Println(playList.Encode().String())

        }

        err := playList.Append(fmt.Sprintf("%d.ts", i), 5.0, "")
        if err != nil {
            fmt.Println(err)
            continue
        }

    }
    

}
