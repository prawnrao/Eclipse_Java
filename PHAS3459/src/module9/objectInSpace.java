package module9;

import java.awt.*;
import javax.swing.*;

public class objectInSpace {
	private double distance;
	private double angle;
	private double speed;
	private double diameter;
	private Color colour;


	public objectInSpace(double distance, double angle, double speed, double diameter, Color colour) {
		this.distance = distance;
		this.angle = angle;
		this.speed = speed;
		this.diameter = diameter;
		this.colour = colour;
	}

	public double getDistance() {
		return distance;
	}

	public double getAngle() {
		return angle;
	}

	public double getSpeed() {
		return speed;
	}

	public Color getColour() {
		return colour;
	}

	public double getDiameter() {
		return diameter;
	}

	public void move() {

	}
}
