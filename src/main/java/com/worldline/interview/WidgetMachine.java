package com.worldline.interview;

public class WidgetMachine {
	
	private InternalCombustionEngine engine;

	private SteamEngine streamEngine;

	public WidgetMachine(InternalCombustionEngine engine) {
        this.engine = engine;
    }
	
	public WidgetMachine(SteamEngine streamEngine) {
        this.streamEngine = streamEngine;
    }

    public int produceWidgets(int quantity) {
        engine.start();
        int cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private int produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        int costPerBatch = 0;

        if (engine.getFuelType() == FuelType.PETROL) {
            costPerBatch = 9;
        } else if (engine.getFuelType() == FuelType.DIESEL) {
            costPerBatch = 12;
        }

        while (batch < quantity) {
            batch = batch + 8;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }
    
    public double produceWidgetsUsingSteamEngine(int quantity) {
    	streamEngine.start();
    	double cost = 0;

        if (streamEngine.isRunning()) {
            cost = produceUsingSteamEngine(quantity);
        }

        streamEngine.stop();

        return cost;
    }

    private double produceUsingSteamEngine(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = 0;

        if (streamEngine.getFuelType() == FuelType.WOOD) {
            costPerBatch = FuelType.WOOD.getFuelCost();
        } else if (streamEngine.getFuelType() == FuelType.COAL) {
            costPerBatch = FuelType.COAL.getFuelCost();
        }

        while (batch < quantity) {
            batch = batch + 2;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }
}
