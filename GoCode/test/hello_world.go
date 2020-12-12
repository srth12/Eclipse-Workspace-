package main

import (
	"fmt"
	"net/http"
	"test"
)

func main() {

	fmt.Println("Hello World")
	main.Greetings()
	response, error := http.Get("https://google.com")
	if error != nil {
		panic(error)
	}
	defer response.Body.Close()
	fmt.Println("status is " + response.Status)
}
