package onlineShop.log;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//if use java-based configuration, no need of @Component
@Component
//this class is also a bean

public class PaymentAction {
	@Autowired
	private Logger logger;
	//above is to inject the Logger to this class
	
	public void pay(BigDecimal payValue) {
		logger.log("pay begin, payValue is " + payValue);
		logger.log("pay end.");
	}
}
