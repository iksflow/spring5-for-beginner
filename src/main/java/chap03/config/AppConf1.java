package chap03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap03.MemberDao;
import chap03.MemberPrinter;

@Configuration
public class AppConf1 {
	@Bean
	public MemberDao memberDao() {
		System.out.println("memberDao 호출");
		return new MemberDao();
	}
	
	@Bean MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
