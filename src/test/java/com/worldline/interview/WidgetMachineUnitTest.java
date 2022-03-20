package com.worldline.interview;

import static org.hamcrest.Matchers.closeTo;
import org.junit.Assert;
import org.junit.Test;

public class WidgetMachineUnitTest {

	private WidgetMachine widget;
	
	@Test
    public void internalCombustionEngineWithPetrolFuel() {
		
		InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
		engine.fill(FuelType.PETROL, 100);
		
		widget =  new WidgetMachine(engine);
		int cost = widget.produceWidgets(5);
		
		Assert.assertEquals(cost, 9);
	}
	
	@Test
    public void internalCombustionEngineWithDieselFuel() {
		
		InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
		engine.fill(FuelType.DIESEL, 100);
		
		widget =  new WidgetMachine(engine);
		int cost = widget.produceWidgets(5);
		
		Assert.assertEquals(cost, 12);
	}
	
	@Test
    public void steamEngineWithWoodFuel() {
		
		SteamEngine engine = new SteamEngine(FuelType.WOOD);
		engine.fill(FuelType.WOOD, 100);
		
		widget =  new WidgetMachine(engine);
		Double cost = widget.produceWidgetsUsingSteamEngine(50);
		
		Assert.assertThat(cost, closeTo(0.00, 108.75));
	}
	
	@Test
    public void steamEngineWithCoalFuel() {
		
		SteamEngine engine = new SteamEngine(FuelType.COAL);
		engine.fill(FuelType.COAL, 100);
		
		widget =  new WidgetMachine(engine);
		Double cost = widget.produceWidgetsUsingSteamEngine(50);
		
		Assert.assertThat(cost, closeTo(0.00, 141.25));
	}
}
