package com.gikk.fruit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Factories
{
	private final Map<String, FruitFactory> factories = new HashMap<>();

	public void register(String type, FruitFactory factory)
	{
		factories.put(type, factory);
	}

	public FruitFactory getFactory(String key)
	{
		return factories.get(key);
	}
}
