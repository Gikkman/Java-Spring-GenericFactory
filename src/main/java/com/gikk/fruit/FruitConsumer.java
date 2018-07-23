package com.gikk.fruit;

public interface FruitConsumer<T extends Fruit>
{
	public String consume(T fruit);
}
