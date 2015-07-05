package com.zhenai.exercise.io;

import innerclasses.GreenhouseControls;
import innerclasses.controller.Event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exercise11 {
	public static void main(String[] args) throws IOException {
		GreenhouseControls gc = new GreenhouseControls();
		// Instead of hard-wiring, you could parse
		// configuration information from a text file here:
		gc.addEvent(gc.new Bell(900));

		List el = new ArrayList<Event>();
		EventFactory ef = new EventFactory(); // define a factory
		String filename = "D:\\workspace\\Prj_test\\src\\tij\\io\\configuration.txt";
		BufferedReader in = new BufferedReader(new FileReader(filename)); // read
																			// configuration
																			// from
																			// text
																			// file.
		String s;
		while ((s = in.readLine()) != null) {
			String[] eventDesc = s.split(",");
			String type = eventDesc[0];
			Long delay = Long.parseLong(eventDesc[1]);
			el.add(ef.createEvent(type, delay));
		}

		Event[] eventList = (Event[]) el.toArray(new Event[el.size()]);
		gc.addEvent(gc.new Restart(2000, eventList));
		if (args.length == 1)
			gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
		gc.run();
	}
} /*
 * Output: Bing! Thermostat on night setting Light is on Light is off Greenhouse
 * water is on Greenhouse water is off Thermostat on day setting Restarting
 * system Terminating
 */// :~
