package designPatterns.abstractFactory;

public class BMailFactory implements Provider{

	@Override
	public Sender produce() {
		return new BMailSender();
	}

}
