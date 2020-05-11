package chap05;

import org.springframework.stereotype.Component;

@Component
public class MemberSummaryPrinter extends MemberPrinter {

	@Override
	public void print(Member member) {
		System.out.printf(
				"회원정보: 이메일=%s, 이름=%s\n",
				member.getEmail(), member.getName()
				);
	}
}
