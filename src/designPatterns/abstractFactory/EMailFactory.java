package designPatterns.abstractFactory;

public class EMailFactory implements Provider{

	@Override
	public Sender produce() {
		return new EMailSender();
	}

}
