package designPatterns.factoryMethod;

/**
 * 普通工厂
 * 
 * @author lin
 * @date 2016年3月12日 下午10:35:16
 */
public class SendFactory {
	public Sender produce(String type) {  
        if ("mail".equals(type)) {  
            return new EMailSender();  
        } else if ("sms".equals(type)) {  
            return new BMailSender();  
        } else {  
            System.out.println("请输入正确的类型!");  
            return null;  
        }  
    }  

}
