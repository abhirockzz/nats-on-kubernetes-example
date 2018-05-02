package com.wordpress.simplydistributed.nats.producer;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NATSProducer {
    
    final static String SUBJECT = "foo";
    
    public static void main(String[] args) throws Exception {
        Options.Builder builder = new Options.Builder();
        Options options = builder.timeout(3, TimeUnit.SECONDS)
                .reconnectWait(5, TimeUnit.SECONDS)
                .maxReconnect(5)
                .build();
        
        String natsServer = System.getenv("EXAMPLE_NATS_1_SERVICE_HOST");
        //if(natsServer == null){natsServer = "example-nats-1";}
		//String natsServer = "example-nats-1";
        System.out.println("NATS server running on --- "+ natsServer);
        
        String natsURL = "nats://"+natsServer+":4222";
        System.out.println("NATS conn URL --->> "+ natsURL);
        
        //Connection nc = Nats.connect("nats://192.168.99.100:4222", options);
        Connection nc = Nats.connect(natsURL, options);
        
        System.out.println("Connected");
        while(true){
            String msg = "Hello World "+ new Date();
            nc.publish(SUBJECT, msg.getBytes());
            System.out.println("Sent message - '" + msg + "'");
            Thread.sleep(5000);
        }
        
    }
}
