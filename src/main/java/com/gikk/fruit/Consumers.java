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
public class Consumers
{
	private final Map<Class<? extends Fruit>, Collection<FruitConsumer<? extends Fruit>>> consumers = new HashMap<>();

	public <T extends Fruit> void register(Class<T> clazz, FruitConsumer<T> consumer)
	{
		consumers.putIfAbsent(clazz, new HashSet<>());
		consumers.get(clazz).add(consumer);
	}

	public <T extends Fruit> String consume(T fruit)
	{
		// It is safe to cast a class to it's own super class.
		Class<? super T> key = (Class<? super T>) fruit.getClass();

		List<String> responses = new ArrayList<>();
		do
		{
			Collection<FruitConsumer<? extends Fruit>> cons = consumers.get(key);
			for (FruitConsumer<? extends Fruit> c : cons)
			{
				// Safe cast, due to the register-method requirements
				FruitConsumer<T> consumer = (FruitConsumer<T>) c;

				String response = consumer.consume(fruit);
				responses.add(response);
			}
		}
		while (key != Fruit.class && (key = key.getSuperclass()) != null);

		return responses.stream().collect(Collectors.joining(" | ", "[", "]"));
	}
}
