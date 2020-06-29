package main

import (
	"fmt"
	"sync"
)

var wg = sync.WaitGroup{}

func main(){

	fmt.Println("Hello World")
	channelIntroBidirectional()
	channelIntroUnidirectional()
}

func channelIntroUnidirectional(){
	ch := make(chan int) // channel can only be created with make, no shortcuts
	wg.Add(2)

	go func(ch <- chan int){ //receive only goroutine

		i := <- ch
		fmt.Println(i)
		// ch <- 5  this will throuwn exceptin as its a receive only channel
		wg.Done()
	}(ch)

	go func(ch chan <- int){ // send only channel
		i := 99
		ch <- i  // pass the copy only
		wg.Done()
	}(ch)

	wg.Wait()
}

func channelIntroBidirectional(){
	ch := make(chan int) // channel can only be created with make, no shortcuts
	wg.Add(2)

	go func(){

		i := <- ch
		fmt.Println(i)
		ch <- 33
		wg.Done()
	}()

	go func(){
		i := 44
		ch <- i  // pass the copy only
		fmt.Println(<-ch)
		wg.Done()
	}()

	wg.Wait()
}