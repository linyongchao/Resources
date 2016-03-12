package designPatterns.factoryMethod;

public class EMailSender implements Sender{

	@Override
	public void Send() {
		System.out.println("this is email sender!"); 		
	}

}
