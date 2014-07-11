package helloice;

import Demo.PrinterPrx;
import Demo.PrinterPrxHelper;
import Ice.Communicator;
import Ice.InitializationData;
import Ice.ObjectPrx;
import Ice.Properties;
import Ice.Util;
import java.io.PrintStream;

public class OneWayProxiesTest implements Runnable
{
	private static Communicator ic;
	private static PrinterPrx printer;
	private static PrinterPrx oneWayPrx;

	public static void main(String[] paramArrayOfString)
	{
		try
		{
			// Properties localProperties = Util.createProperties();
			// localProperties.setProperty("Ice.Trace.Slicing", "1");
			// InitializationData localInitializationData = new InitializationData();
			// localInitializationData.properties = localProperties;

			ic = Util.initialize(); // paramArrayOfString, localInitializationData);
			
			ObjectPrx localObjectPrx = ic.stringToProxy("SimplePrinter:default -p 10000");
			printer = PrinterPrxHelper.checkedCast(localObjectPrx);
			
			oneWayPrx = PrinterPrxHelper.checkedCast(ic.stringToProxy("SimplePrinter:default -p 10000"));

			System.out.println("Setting to one way");
			oneWayPrx = PrinterPrxHelper.checkedCast(oneWayPrx.ice_oneway());
			
			System.out.println("Setting ice connection id");
			oneWayPrx = PrinterPrxHelper.checkedCast(oneWayPrx.ice_connectionId("oneway"));

		}
		catch (Exception localException1)
		{
			System.err.println(localException1);
			System.exit(-1);
		}

		new Thread(new OneWayProxiesTest()).start();

		System.out.println("Sleeping");
		try
		{
			Thread.sleep(5000L);
		}
		catch (Exception localException2) {}

		for (int i=0; i<10000; i++) {
			System.out.println("Making oneway call");
			oneWayPrx.oneway();
			System.out.println("Made oneway call");
		}

		try
		{
			Thread.sleep(120000L);
		}
		catch (Exception localException3) {}
		System.exit(-1);
	}

	public void run()
	{
		try
		{
			System.out.println("Calling blockForever");
			printer.blockForever();
			System.out.println("Called blockForever");
		}
		catch (Exception localException)
		{
			localException.printStackTrace();
		}
	}
}

