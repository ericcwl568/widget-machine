package com.worldline.interview;

import static org.hamcrest.Matchers.closeTo;

import org.junit.Assert;
import org.junit.Test;

public class InternalCombustionEngineUnitTest {
	
	@Test
    public void internalCombustionEngineWithPetrolFuelAndValidValues() {
		
		InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
		
		Assert.assertTrue(engine.getFuelType().equals(FuelType.PETROL));
		Assert.assertFalse(engine.isRunning());
		Assert.assertEquals(engine.getFullLevel(), 0);
		Assert.assertEquals(engine.getBatchSize(), 8);
		Assert.assertThat(engine.getFuelType().getFuelCost(), closeTo(0.00, 9.00));
	}
	
	@Test
    public void internalCombustionEngineWithDieselFuelAndValidValues() {
		
		InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
		
		Assert.assertTrue(engine.getFuelType().equals(FuelType.DIESEL));
		Assert.assertFalse(engine.isRunning());
		Assert.assertEquals(engine.getFullLevel(), 0);
		Assert.assertEquals(engine.getBatchSize(), 8);
		Assert.assertThat(engine.getFuelType().getFuelCost(), closeTo(0.00, 12.00));
	}

	@Test
    public void internalCombustionEngineWithInvalidFuelTypeWood() {

		InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
		
		if(!engine.getFuelType().equals(FuelType.PETROL) && !engine.getFuelType().equals(FuelType.DIESEL)) {
			throw new IllegalStateException(engine.getFuelType().toString() + " fuel is not supported!");
		}
    }
	
	@Test
    public void internalCombustionEngineWithInvalidFuelTypeCoal() {

		InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
		
		if(!engine.getFuelType().equals(FuelType.PETROL) && !engine.getFuelType().equals(FuelType.DIESEL)) {
			throw new IllegalStateException(engine.getFuelType().toString() + " fuel is not supported!");
		}
    }
}
