package org.soumen.springdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * @author soumen
 * IN Spring framework every object contains inside the "Sprin Container" just like apache container
 *        contains servlet and has the full responsibility to create the servlet framework
 * In Spring , it provide a factory bean concept which help user to use particular object. here user
 *       not required to create object they will just call the 'Factory Bean' which will create the specific
 *       object internally and return it.
 * Here we need to mention all the obeject creation criteria in am xml which will be used by the
 * spring factory bean at the time of creation object while user reqest for the object   
 *
 */
public class Draw {

	public static void main(String[] args) {
		createObjectUsingApplicationConetext();
		
		//createObjectUsingBeanFactory();
	}

	/**
	 * We can create object using bean factory in Spring, But there is another way we can create 
	 *       object is using Spring applicationContext.
	 *ApplicationContext use the same xml configuration to create object but it has some extra
	 *capabilities compare to beanfacorty like 'eventNotification', 'AOP' etc. 
	 * 
	 */
	private static void createObjectUsingApplicationConetext() {
		//initialize the application-context, pass configuration xml as to intilize it
		//you need to instantiate classPathXmlApplicationCOntext and pass the xml name  
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		
		//get the object from the context only by passing its name
		Car car=(Car) context.getBean("car");
		
		//call any method of the object
		car.start();
		
	}

	/**
	 * initialize the spring BeanFactory. as we are using xml configuration bean so we need to
	 *get xmlBeanFactory. we need to pass our xml configuration file as argument of FileSystemResource
	 *to figure out the object creation condition by the spring beanfactory
	 */
	private static void createObjectUsingBeanFactory() {
		
		BeanFactory bean=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		
		//getting the trinagle object form the created bean by passing the id mention the bean configuration
		//i.e. 'triangle'
		Car car=(Car) bean.getBean("car");
				
		//now calling the draw method of the triangle obejct
		car.start();
	}

}
