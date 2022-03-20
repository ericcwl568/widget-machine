package com.worldline.interview;

import static org.hamcrest.Matchers.closeTo;

import org.junit.Assert;
import org.junit.Test;

public class SteamEngineUnitTest {

	@Test
    public void steamEngineWithWoodFuelAndValidValues() {
		
		SteamEngine engine = new SteamEngine(FuelType.WOOD);
		
		Assert.assertTrue(engine.getFuelType().equals(FuelType.WOOD));
		Assert.assertFalse(engine.isRunning());
		Assert.assertEquals(engine.getFullLevel(), 0);
		Assert.assertEquals(engine.getBatchSize(), 2);
		Assert.assertThat(engine.getFuelType().getFuelCost(), closeTo(0.00, 4.35));
	}
	
	@Test
    public void steamEngineWithCoalFuelAndValidValues() {
		
		SteamEngine engine = new SteamEngine(FuelType.COAL);
		
		Assert.assertTrue(engine.getFuelType().equals(FuelType.COAL));
		Assert.assertFalse(engine.isRunning());
		Assert.assertEquals(engine.getFullLevel(), 0);
		Assert.assertEquals(engine.getBatchSize(), 2);
		Assert.assertThat(engine.getFuelType().getFuelCost(), closeTo(0.00, 5.65));
	}
	
	@Test
    public void steamEngineWithInvalidFuelTypePetrol() {

		SteamEngine engine = new SteamEngine(FuelType.WOOD);
		
		if(!engine.getFuelType().equals(FuelType.WOOD) && !engine.getFuelType().equals(FuelType.COAL)) {
			throw new IllegalStateException(engine.getFuelType().toString() + " fuel is not supported!");
		}
    }
	
	@Test
    public void steamEngineWithInvalidFuelTypeDiesel() {

		SteamEngine engine = new SteamEngine(FuelType.COAL);
		
		if(!engine.getFuelType().equals(FuelType.WOOD) && !engine.getFuelType().equals(FuelType.COAL)) {
			throw new IllegalStateException(engine.getFuelType().toString() + " fuel is not supported!");
		}
    }
}
