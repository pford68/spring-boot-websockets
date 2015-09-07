package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by philip on 9/7/15.
 */
@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMesage message) throws Exception {
        Thread.sleep(3000);  // Simulated delay, not a necessary part of the code
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
