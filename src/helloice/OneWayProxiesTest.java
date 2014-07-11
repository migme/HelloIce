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

	public static void main(String[] paramArrayOfString)
	{
		try
		{
			Properties localProperties = Util.createProperties();
			localProperties.setProperty("Ice.Trace.Slicing", "1");

			InitializationData localInitializationData = new InitializationData();
			localInitializationData.properties = localProperties;

			ic = Util.initialize(paramArrayOfString, localInitializationData);
			ObjectPrx localObjectPrx = ic.stringToProxy("SimplePrinter:default -p 10000");
			printer = PrinterPrxHelper.checkedCast(localObjectPrx);
		}
		catch (Exception localException1)
		{
			System.err.println(localException1);
		}

		new OneWayProxiesTest().run();

		try
		{
			Thread.sleep(5000L);
		}
		catch (Exception localException2) {}

		printer.oneway();
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

