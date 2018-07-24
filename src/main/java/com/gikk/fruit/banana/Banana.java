package com.gikk.fruit.banana;

import com.gikk.fruit.Fruit;

public class Banana extends Fruit
{
	private final int weight;

	Banana(int weight)
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
		return "Yellow";
	}

}
