package helloice;

import Demo.PrinterPrx;
import Demo.PrinterPrxHelper;
import Ice.Communicator;
import Ice.InitializationData;
import Ice.ObjectPrx;
import Ice.Properties;
import Ice.Util;
import java.io.PrintStream;

public class OneWayCallsAgainstDeactivatedServantTest
{
	public static void main(String[] paramArrayOfString) throws Exception {
		final Communicator ic = Util.initialize();
		
		ObjectPrx localObjectPrx = ic.stringToProxy("SimplePrinter:default -p 10000");
		final PrinterPrx printer = PrinterPrxHelper.checkedCast(localObjectPrx);
		
		PrinterPrx oneWayPrx = PrinterPrxHelper.checkedCast(ic.stringToProxy("SimplePrinter:default -p 10000"));

		System.out.println("Setting to one way");
		oneWayPrx = PrinterPrxHelper.checkedCast(oneWayPrx.ice_oneway());

		for (int i=0; i<10; i++) {
			System.out.println("Making oneway call");
			oneWayPrx.onewayTestDeactivatedServant();
			System.out.println("Made oneway call");
		}

		System.out.println("******** sleeping ************");
		Thread.sleep(20000);
		System.out.println("******** slept ************");

		for (int i=0; i<10; i++) {
			System.out.println("Making oneway call");
			try {
				oneWayPrx.onewayTestDeactivatedServant();
				System.out.println("Made oneway call");
			}
			catch (Exception e) {
				System.out.println("Exception making oneway call: e=" + e);				
			}
		}
		
		System.out.println("OneWayCallsAgainstDeactivatedServantTest is done");
	}
}

