package designPatterns.factoryMethod;

public class ManySendFactoryTest {
	public static void main(String[] args) {  
        ManySendFactory factory = new ManySendFactory();  
        Sender sender = factory.produceMail();  
        sender.Send();  
    }
}
