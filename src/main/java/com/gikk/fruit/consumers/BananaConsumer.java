package com.gikk.fruit.consumers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gikk.fruit.Consumers;
import com.gikk.fruit.FruitConsumer;
import com.gikk.fruit.apple.Apple;
import com.gikk.fruit.banana.Banana;

@Component
public class BananaConsumer implements FruitConsumer<Banana>
{
	@Autowired
	Consumers c;

	@PostConstruct
	void post()
	{
		c.register(Banana.class, this);
		c.register(Apple.class, this);
	}

	@Override
	public String consume(Banana banana)
	{
		StringBuilder b = new StringBuilder();
		b.append("A banana! ");
		b.append("Mmm, a " + banana.getColor() + " banana, at " + banana.getWeight() + " grams!");
		return b.toString();
	}
}
