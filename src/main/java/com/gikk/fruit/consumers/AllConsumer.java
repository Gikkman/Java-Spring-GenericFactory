package com.gikk.fruit.consumers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gikk.fruit.Consumers;
import com.gikk.fruit.Fruit;
import com.gikk.fruit.FruitConsumer;

@Component
public class AllConsumer implements FruitConsumer<Fruit>
{
	@Autowired
	Consumers c;

	@PostConstruct
	void post()
	{
		c.register(Fruit.class, this);
	}

	@Override
	public String consume(Fruit fruit)
	{
		StringBuilder b = new StringBuilder();
		b.append("FRUIT SALAD INGREDIENT!!! ");
		b.append("Mmm, a " + fruit.getColor() + " fruit, at " + fruit.getWeight() + " grams!");
		return b.toString();
	}
}
