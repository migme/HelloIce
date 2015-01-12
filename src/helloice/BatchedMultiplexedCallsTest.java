package helloice;

import Demo.PrinterPrx;
import Demo.PrinterPrxHelper;
import Ice.Communicator;
import Ice.InitializationData;
import Ice.ObjectPrx;
import Ice.Properties;
import Ice.Util;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class BatchedMultiplexedCallsTest
{
	final static int ENTITY_COUNT = 100;
	final static Communicator ic = Util.initialize();
	
	final Map<String,PrinterPrx> multiplexerLookup = new HashMap<String,PrinterPrx>();
	final CountDownLatch finishedLatch = new CountDownLatch(ENTITY_COUNT);

	final AtomicLong totalBatchedTime = new AtomicLong(0);
	final AtomicLong totalNonBatchedTime = new AtomicLong(0);

	public static void main(String[] args) throws Exception {
		new BatchedMultiplexedCallsTest().test();
	}
		
	public void test() throws Exception {
		ObjectPrx localObjectPrx = ic.stringToProxy("SimplePrinter:default -p 10000");
		final PrinterPrx printer = PrinterPrxHelper.checkedCast(localObjectPrx);		
		final PrinterPrx oneway = PrinterPrxHelper.checkedCast(printer.ice_oneway());
		final PrinterPrx batchedOneway = PrinterPrxHelper.checkedCast(printer.ice_batchOneway());
		
		for (int i=0; i<ENTITY_COUNT; i++) {
			Entity u = new Entity();
			multiplexerLookup.put(u.getMultiplexerKey(), batchedOneway);
			new Thread(u).start();
		}

		finishedLatch.await();
		
		System.out.println("Total batched time=" + totalBatchedTime.get());
		System.out.println("Total non batched time=" + totalNonBatchedTime.get());
	}
	
	private class Entity implements Runnable {
		private String multiplexerKey = UUID.randomUUID().toString();

		public void run() {
			final ObjectPrx op = ic.stringToProxy("SimplePrinter:default -p 10000");
			final PrinterPrx printer = PrinterPrxHelper.checkedCast(op);		
			final PrinterPrx ownOneway = PrinterPrxHelper.checkedCast(printer.ice_oneway());

			for (int i=0; i<10; i++) {
				final int n = 20000;
				totalBatchedTime.addAndGet( makeNCalls(n, null));
				totalNonBatchedTime.addAndGet( makeNCalls(n, ownOneway));
			}
			
			finishedLatch.countDown();
		}

		public String getMultiplexerKey() {return multiplexerKey;}
		
		private long makeNCalls(final int n, final PrinterPrx ownOneway) {
			final long start = System.currentTimeMillis();

			for (int i=0; i < n; i++) {
				if (ownOneway == null) {
					final PrinterPrx sharedBatchedOneway = multiplexerLookup.get(multiplexerKey);
					sharedBatchedOneway.incrementMagicLevel();				
				}
				else {			
					ownOneway.incrementMagicLevel();
				}
			}

			return System.currentTimeMillis() - start;
		}
	}
}

