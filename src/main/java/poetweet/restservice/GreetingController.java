package poetweet.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * This is our endpoint.
     * @param name Name of person we're greeting
     * @return idk
     */
    @GetMapping("/greeting")
    public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Hello(
                counter.incrementAndGet(),
                String.format(template, name)
        );
    }
}
