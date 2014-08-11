package chapter19_SalaryCaseStudy.infla;

public class BusinessExcepction extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BusinessExcepction(String message) {
		super(message);
	}

}
