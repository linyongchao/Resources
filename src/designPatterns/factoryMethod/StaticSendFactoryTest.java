package designPatterns.factoryMethod;

public class StaticSendFactoryTest {
	public static void main(String[] args) {      
        Sender sender = StaticSendFactory.produceMail();  
        sender.Send();  
    }
}
