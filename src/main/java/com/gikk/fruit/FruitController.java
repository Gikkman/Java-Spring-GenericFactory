package com.gikk.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController
{
	@Autowired
	Consumers c;
	@Autowired
	Factories f;

	@PostMapping("/create")
	@ResponseBody
	String create(
		@RequestBody
		FruitPrototype proto)
	{
		FruitFactory factory = f.getFactory(proto.type);
		Fruit fruit = factory.create(proto);

		return c.consume(fruit);
	}
}
