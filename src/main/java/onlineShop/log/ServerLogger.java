package onlineShop.log;
import org.springframework.stereotype.Component;

//if use java-based configuration, no need of @Component
@Component
	//this means this class is a bean

public class ServerLogger implements Logger {
	
	public void log(String info) {
		System.out.println("server log = " + info);
	}
}
