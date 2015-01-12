package helloice;

import Demo.PrinterPrx;
import Demo.PrinterPrxHelper;
import Ice.Communicator;
import Ice.InitializationData;
import Ice.ObjectPrx;
import Ice.Properties;
import Ice.Util;
import java.io.PrintStream;

public class BatchedCallsTest
{
	public static void main(String[] paramArrayOfString) throws Exception {
		final Communicator ic = Util.initialize();
		
		ObjectPrx localObjectPrx = ic.stringToProxy("SimplePrinter:default -p 10000");
		final PrinterPrx printer = PrinterPrxHelper.checkedCast(localObjectPrx);		
		final PrinterPrx batchedOneway = PrinterPrxHelper.checkedCast(printer.ice_batchOneway());
		
		int i;
		for (i=0; i<50000; i++) {
			batchedOneway.incrementMagicLevel();
			
			if (i%500==0) {
				System.out.println("Made " + i + " batched oneway calls");
				//batchedOneway.ice_flushBatchRequests();				
			}
		}

		batchedOneway.ice_flushBatchRequests();
		System.out.println("Final total: Made " + i + " batched oneway calls");
	}
}

