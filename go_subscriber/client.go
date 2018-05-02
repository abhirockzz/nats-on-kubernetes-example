package main

import (
	"fmt"
	"runtime"
	"time"
	"os"

	"github.com/nats-io/go-nats"
)

func main() {
	subject := "foo"
	
	natsServer := os.Getenv("EXAMPLE_NATS_1_SERVICE_HOST")
	fmt.Println("NAT server --- "+ natsServer)
	
	natsURL := "nats://"+natsServer+":4222"
	fmt.Println("NAT server conn URL --- "+ natsURL)
	
	opts := nats.Options{
		AllowReconnect: true,
		MaxReconnect:   5,
		ReconnectWait:  5 * time.Second,
		Timeout:        3 * time.Second,
		Url:            natsURL,
	}

	conn, _ := opts.Connect()
	//defer conn.Close()
	fmt.Println("Subscriber connected to NATS server")

	fmt.Printf("Subscribing to subject %s\n", subject)
	conn.Subscribe(subject, func(msg *nats.Msg) {
		fmt.Printf("Got message '%s\n", string(msg.Data)+"'")
	})

	runtime.Goexit()
}
