package designPatterns.factoryMethod;

public class ManySendFactory {
	public Sender produceMail(){  
        return new EMailSender();  
    }  
      
    public Sender produceSms(){  
        return new BMailSender();  
    } 
}
