package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;
	}
	
	@Bean
	public VisitCounter visitCounter() {
		VisitCounter v = new VisitCounter();
		v.setFormat("%d번째 손님! 안녕히 가세요!");
		return v;
	}
}
