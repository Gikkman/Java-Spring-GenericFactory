package com.gikk.fruit.apple;

import com.gikk.fruit.Fruit;

public class Apple implements Fruit
{

	private final int weight;

	Apple(int weight)
	{
		this.weight = weight;
	}

	@Override
	public int getWeight()
	{
		return weight;
	}

	@Override
	public String getColor()
	{
		return "Red";
	}
}
