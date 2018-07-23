package com.gikk.fruit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Consumers<T extends Fruit>
{
	private final Map<Class<T>, Collection<FruitConsumer<T>>> consumers = new HashMap<>();

	public void register(Class<T> clazz, FruitConsumer<T> consumer)
	{
		consumers.putIfAbsent(clazz, new HashSet<>());
		consumers.get(clazz).add(consumer);
	}

	public String consume(T fruit)
	{
		Collection<FruitConsumer<T>> cons = consumers.get(fruit.getClass());
		List<String> responses = new ArrayList<>();
		for (FruitConsumer<T> c : cons)
		{
			String response = c.consume(fruit);
			responses.add(response);
		}
		return responses.stream().collect(Collectors.joining(" | ", "[", "]"));
	}
}
