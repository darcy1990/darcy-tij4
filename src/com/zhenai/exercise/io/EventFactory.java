package com.zhenai.exercise.io;

import innerclasses.GreenhouseControls;
import innerclasses.controller.Event;

public class EventFactory extends Factory {

	@Override
	public Event createEvent(String type, Long delay) {
		GreenhouseControls gc = new GreenhouseControls();
		Event e = null;
		if (type.equals("LightOn")) {
			e = gc.new LightOn(delay);
		} else if (type.equals("LightOff")) {
			e = gc.new LightOff(delay);
		} else if (type.equals("WaterOn")) {
			e = gc.new WaterOn(delay);
		} else if (type.equals("WaterOff")) {
			e = gc.new WaterOff(delay);
		} else if (type.equals("ThermostatNight")) {
			e = gc.new ThermostatNight(delay);
		} else if (type.equals("ThermostatDay")) {
			e = gc.new ThermostatDay(delay);
		}
		return e;
	}

}
