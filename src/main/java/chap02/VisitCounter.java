package chap02;

public class VisitCounter {
	private int count;
	private String format;
	public String sayGoodBye() {
		return String.format(format, count);
	}
	public void increaseCount() {
		count++;
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
