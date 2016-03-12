package designPatterns.abstractFactory;

public class BMailSender implements Sender{

	@Override
	public void Send() {
		System.out.println("this is bmail sender!");		
	}

}
