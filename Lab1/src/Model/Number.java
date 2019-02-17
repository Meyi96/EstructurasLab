package Model;

public class Number {
	
	public String date;
	public double number;
	
	public Number(String date) {
		this.date = date;
		convertDouble();
	}
	
	public double getNumber() {
		return number;
	}
	
	public boolean isFraction() {
		return date.indexOf("/") != -1;
	}
	
	public void convertDouble() {
		if(isFraction())
			convertDecimal();
		else 
			number = Double.parseDouble(date);
	}

	public void convertDecimal() {
		String fraction[] = date.split("/");
		if(fraction.length == 2)
			number = (Double.parseDouble(fraction[0])/Double.parseDouble(fraction[1]));
		else
			number = Double.parseDouble(fraction[0]);
	}
}
