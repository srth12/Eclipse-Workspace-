package main

import (
	"fmt"
	"time"
	"sync"
	"runtime"
	// "io/ioutil"
	// "log"
	// "net/http"
)

// TO sync between multiple go routine
var wg = sync.WaitGroup{}
var counter = 0
var mutexCounter = 0
var wgMutex = sync.WaitGroup{}

// To find race condition, run with `go run -race filename.go`

// Parallel Read possible, but if one write, blocks all other Reads/Writes
var mutex = sync.RWMutex{}

func main(){ // main itself a go routine
	fmt.Println("Max procs ", runtime.GOMAXPROCS(-1)) // return max no of procedures. if 1 only 1 process == no multi threading
	initialGoROutine()
	weightGroupExample()
	// weightGroupExample2() // unordered and the counter wont increament properly
	mutexReadWriteExample()
}

func mutexReadWriteExample(){
	for i := 0; i < 5; i ++ {
		wgMutex.Add(2)
		mutex.RLock()
		go readLockEx()

		mutex.Lock()
		go writeLockEx()
	}
	wgMutex.Wait()
}

func readLockEx(){

	fmt.Printf("Hello read couunter: %v\n", mutexCounter)
	mutex.RUnlock()
	wgMutex.Done()
}

func writeLockEx(){

	fmt.Printf("Hello write couunter: %v \n", mutexCounter)
	mutexCounter ++
	mutex.Unlock()
	wgMutex.Done()
}

func weightGroupExample(){
	wg.Add(1)
	go func(){
		fmt.Println("Hello Go!")
		wg.Done()
	}()
	wg.Wait()
}

func weightGroupExample2(){
	for i := 0; i < 5; i ++ {
		go sayYoy()
		go sayHi()
		wg.Add(2)
	}
	wg.Wait()
}

func sayYoy(){
	fmt.Println("Yoy!")
	wg.Done()
}

func sayHi(){
	fmt.Printf("Hi! %v \n", counter)
	counter++
	wg.Done()
}



func initialGoROutine(){
	// no 1-to-1 mapping of OS thread to go thread; It uses green thread
	// closure issue with anonymous method
	msg := "Start"
	go func(){
		//BAD Practive to use closure variable, it can print both 'start' or 'end'. Use argument instead
		fmt.Println(msg)
	}()
	msg = "End point"

	// better to use argument for anonymous fns
	go func(msg string){
		fmt.Println(msg)
	}(msg)

	time.Sleep(100 * time.Millisecond)
}
