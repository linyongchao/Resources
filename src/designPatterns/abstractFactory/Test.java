package designPatterns.abstractFactory;

public class Test {
	public static void main(String[] args) {  
        Provider provider = new EMailFactory();  
        Sender sender = provider.produce();  
        sender.Send();  
    }  
}
