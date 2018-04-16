package org.snyk.groceries;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.snyk.groceries.domain.Item;
import org.snyk.groceries.repository.ItemRepository;
import org.snyk.groceries.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringGoofApplication extends SpringBootServletInitializer implements ApplicationRunner{

	@Autowired
    private ItemService itemService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringGoofApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(SpringGoofApplication.class);
	}
	
	@Bean
	public CommandLineRunner demo(ItemRepository repository) {
		return (args) -> {
			// save a few of items to the grocery list
			repository.save(new Item("Beans", new Double(0.50D)));
			repository.save(new Item("Milk", new Double(1.09D)));
			repository.save(new Item("Bread", new Double(1.5D)));
			repository.save(new Item("Sausages", new Double(4.99D)));
			repository.save(new Item("Beer", new Double(5.99D)));

			// fetch all items on the grocery list
			System.out.println("Items found with findAll():");
			System.out.println("-------------------------------");
			for (Item item : repository.findAll()) {
				System.out.println(item.toString());
			}
			System.out.println("");

			// fetch items by name
			System.out.println("Item found with findByName('Bread'):");
			System.out.println("--------------------------------------------");
			repository.findByName("Bread").forEach(System.out::println);
			};
		};
		
		@Bean
	    public FilterRegistrationBean filterRegistrationBean() {
	        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	        StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter();
	        registrationBean.setFilter(struts);
	        registrationBean.setOrder(1);
	        return registrationBean;
	    }
	 
	    @Override
	    public void run(ApplicationArguments args) throws Exception {
	        itemService.getAllItems();
	    }
}
