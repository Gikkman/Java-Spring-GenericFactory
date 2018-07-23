package com.gikk.fruit;

public interface FruitFactory<T extends Fruit>
{
	public T create(FruitPrototype prototype);
}
