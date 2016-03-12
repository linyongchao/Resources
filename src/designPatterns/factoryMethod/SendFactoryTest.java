package designPatterns.factoryMethod;

public class SendFactoryTest {
	public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("sms");  
        sender.Send();  
    }  
}
