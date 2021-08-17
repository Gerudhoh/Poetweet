package poetweet;

public final class HelloWorld {

    /**
     * Constructor.
     */
    private HelloWorld() {
        //not called
    }

    /**
     * This the main.
     * @param args args
     */
    public static void main(String[] args) {
        Hello greeter = new Hello();
        System.out.println(greeter.sayPlainTextHello());
    }
}
