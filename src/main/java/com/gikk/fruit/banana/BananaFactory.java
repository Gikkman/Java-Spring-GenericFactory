package com.gikk.fruit.banana;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gikk.fruit.Factories;
import com.gikk.fruit.FruitFactory;
import com.gikk.fruit.FruitPrototype;

@Component
class BananaFactory implements FruitFactory<Banana>
{
	@Autowired
	Factories factories;

	@PostConstruct
	void post()
	{
		factories.register("BANANA", this::create);
	}

	@Override
	public Banana create(FruitPrototype prototype)
	{
		return new Banana(prototype.weight);
	}
}
