package com.gikk.fruit.consumers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gikk.fruit.Consumers;
import com.gikk.fruit.FruitConsumer;
import com.gikk.fruit.apple.Apple;

@Component
public class AppleConsumer implements FruitConsumer<Apple>
{
	@Autowired
	Consumers c;

	@PostConstruct
	void post()
	{
		c.register(Apple.class, this);
	}

	@Override
	public String consume(Apple apple)
	{
		StringBuilder b = new StringBuilder();
		b.append("An apple! ");
		b.append("Mmm, a " + apple.getColor() + " apple, at " + apple.getWeight() + " grams!");
		return b.toString();
	}
}
