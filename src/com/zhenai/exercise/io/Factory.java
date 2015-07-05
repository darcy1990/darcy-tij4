package com.zhenai.exercise.io;

import innerclasses.controller.Event;

public abstract class Factory {

	public abstract Event createEvent(String type, Long delay);

}
