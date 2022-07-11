package application;

public class Vector {
	
	public static void main(String[] args) {
		Vector v = new Vector(5.0, 5.0);
		v.setMag(5);
		System.out.println(v.getMag());
	}

	private double x;
	private double y;
			
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		String x = String.valueOf(this.x);
		String y = String.valueOf(this.x);
		return "Vector("+x+", "+y+")";
	}
	
	public double getMag() {
		return Math.sqrt((double) (this.x*this.x)+(this.y*this.y));
	}
	
	public double getMagSq() {
		return (double) (this.x*this.x)+(this.y*this.y);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void normalize() {
		double mag = this.getMag();
		this.x/=mag;
		this.y/=mag;
	}
	
	public void limit(double maxLimit) {
		if (this.getMag() > maxLimit) {
			this.setMag(maxLimit);
		}
	}
	
	public void setMag(double mag) {
		this.normalize();
		this.x*=mag;
		this.y*=mag;
	}
	
	public double getAngle() {
		double ratio = this.y/this.x;
		double angle = Math.toDegrees(Math.atan(ratio));
		
		return angle;
	}
	
}
