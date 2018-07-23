package com.gikk.fruit.consumers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gikk.fruit.Consumers;
import com.gikk.fruit.Fruit;
import com.gikk.fruit.FruitConsumer;
import com.gikk.fruit.apple.Apple;
import com.gikk.fruit.banana.Banana;

@Component
public class AllConsumer implements FruitConsumer<Fruit>
{
	@Autowired
	Consumers c;

	@PostConstruct
	void post()
	{
		c.register(Apple.class, this);
		c.register(Banana.class, this);
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
