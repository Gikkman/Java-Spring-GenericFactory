package com.gikk.fruit.apple;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gikk.fruit.Factories;
import com.gikk.fruit.FruitFactory;
import com.gikk.fruit.FruitPrototype;

@Component
class AppleFactory implements FruitFactory<Apple>
{
	@Autowired
	Factories factories;

	@PostConstruct
	void post()
	{
		factories.register("APPLE", this::create);
	}

	@Override
	public Apple create(FruitPrototype prototype)
	{
		return new Apple(prototype.weight);
	}
}
