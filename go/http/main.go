package main

import (
	"net/http"
	"sync"
)

type YaToken struct {
	value string
	lock  *sync.RWMutex
}

func NewYaToken() *YaToken {
	yaToken := &YaToken{
		lock: &sync.RWMutex{},
	}
	return yaToken
}

func (t *YaToken) Update() error {
	t.lock.Lock()
	defer t.lock.Unlock()

	token, err := getToken()
	if err != nil {
		return err
	}

	t.value = token
	return nil
}

func (t *YaToken) Get() string {
	t.lock.RLock()
	defer t.lock.RUnlock()

	return t.value
}

func getToken() (token string, err error) {
	// 假设你这里通过一个 http 接口获取到 token，这里我简单用个字符串代替
	return "12345678", nil
}

type YaRoundTrip struct {
	wrapper http.RoundTripper
	yaToken *YaToken
}

func NewYaRoundTrip(t *YaToken, rt http.RoundTripper) http.RoundTripper {
	return &YaRoundTrip{
		wrapper: rt,
		yaToken: t,
	}
}

func (t *YaRoundTrip) RoundTrip(req *http.Request) (resp *http.Response, err error) {
	const (
		Key    = "Authorization"
		Bearer = "Bearer "
	)

	req.Header.Set(Key, Bearer+t.yaToken.Get())
	resp, err = t.wrapper.RoundTrip(req)

	if resp != nil && resp.StatusCode == http.StatusUnauthorized {
		err = t.yaToken.Update()
		if err != nil {
			return resp, err
		}

		req.Header.Set(Key, Bearer+t.yaToken.Get())
		resp, err = t.wrapper.RoundTrip(req)

	}
	return
}

func main() {
	var (
		yaToken    = NewYaToken()
		transport  = NewYaRoundTrip(yaToken, http.DefaultTransport)
		httpClient = http.Client{
			Transport: transport,
		}
	)

	httpClient.Get("http://www.baidu.com")
}
