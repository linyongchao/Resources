package designPatterns.factoryMethod;

/**
 * 静态工厂
 * 
 * @author lin
 * @date 2016年3月12日 下午10:35:35
 */
public class StaticSendFactory {
	public static Sender produceMail(){  
        return new EMailSender();  
    }  
      
    public static Sender produceSms(){  
        return new BMailSender();  
    }  
}
