//in pom.xml: we have:
//spring-webmvc, spring-core, spring-orm, jstl, hibernate-core, spring-security, 
//jackson-core, spring-webflow, mysql-connector-java

package onlineShop.log;

public interface Logger {
	public void log(String info);
}
