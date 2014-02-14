
public class Client implements Runnable {
	
	private static String[] args;
	
    public static void main(String[] args) {
    	Client.args = args;
    	
    	new Client().run();
    	
    	// new Thread(new Client()).start();
    	// new Thread(new Client()).start();
    	// new Thread(new Client()).start();
    	
    	try {
    		Thread.sleep(120000);
    	}
    	catch (Exception e) {}
    	
        System.exit(-1);
    }
    
    public void run() {
    	System.out.println("Entering Client.run");
    	
        int status = 0;
        Ice.Communicator ic = null;
        try {
        	Ice.Properties properties = Ice.Util.createProperties();
        	properties.setProperty("Ice.Default.CollocationOptimized", "0");
        	
        	final boolean LOW_THREADS = true;
        	if (LOW_THREADS) {
        		properties.setProperty("Ice.ThreadPool.Client.Size", "1");
        		properties.setProperty("Ice.ThreadPool.Client.SizeMax", "1");
        	}

        	properties.setProperty("Ice.Trace.Slicing", "1");

        	Ice.InitializationData id = new Ice.InitializationData();
        	id.properties = properties;
        	
            ic = Ice.Util.initialize(args, id);
            Ice.ObjectPrx base = ic.stringToProxy("SimplePrinter:default -p 10000");
            Demo.PrinterPrx printer = Demo.PrinterPrxHelper.checkedCast(base);
            if (printer == null)
                throw new Error("Invalid proxy");

            /*
            System.out.println();
            System.out.println("Client calling Printer.circular... t=" + System.currentTimeMillis());
            printer.circular("Hello World! -- via circular", 5);
            System.out.println("Client called Printer.circular... t=" + System.currentTimeMillis());
            System.out.flush();
			*/
            
            /*
            System.out.println();
            System.out.println("Client calling Printer.oldAmiPrintString_async... t=" + System.currentTimeMillis());
            printer.oldAmiPrintString_async(new PrintStringCallback(), "Hello World! -- via oldAmiPrintString");
            System.out.println("Client called Printer.oldAmiPrintString_async... t=" + System.currentTimeMillis());
            System.out.flush();

            System.out.println();
            System.out.println("Client calling Printer.amdPrintString... t=" + System.currentTimeMillis());
            printer.amdPrintString("Hello World! -- via amdPrintString");
            System.out.println("Client called Printer.amdPrintString... t=" + System.currentTimeMillis());
            System.out.flush();

            System.out.println();
            System.out.println("Client calling Printer.amdCircular... t=" + System.currentTimeMillis());
            printer.amdCircular("Hello World! -- via amdCircular", 5);
            System.out.println("Client called Printer.amdCircular... t=" + System.currentTimeMillis());
            System.out.flush();
            */

            System.out.println();
            System.out.println("Client calling Printer.amdAmiCircular_async... t=" + System.currentTimeMillis());
            printer.amdAmiCircular_async(new AmdAmiCircularCallback(), "Hello World! -- via amdAmiPrintString", 1000);
            System.out.flush();

			try {
				Thread.sleep(5000);
			} catch(Exception e) {
			}

			/*
            System.out.println();
            System.out.println("Client calling Printer.amdAppThreadCircular... t=" + System.currentTimeMillis());
            printer.amdAppThreadCircular("Hello World! -- via amdAppThreadCircular", 1000);
            System.out.println("Client called Printer.amdAppThreadCircular... t=" + System.currentTimeMillis());
            System.out.flush();
			*/

            // WONT WORK
            /*
            System.out.println();
            System.out.println("Client calling Printer.oldAmiCircular... t=" + System.currentTimeMillis());
            printer.oldAmiCircular_async(new Client.CircularCallback(),
            		"Hello World! -- via oldAmiCircular", 5);
            System.out.println("Client called Printer.oldAmiCircular... t=" + System.currentTimeMillis());
            System.out.flush();
			*/
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            // Clean up
            //
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }    	
    }
    
    public static class PrintStringCallback extends Demo.AMI_Printer_oldAmiPrintString {
    	public void ice_response()
    	{
	    	System.out.println("ice_response");
    	}
    	public void ice_exception(Ice.UserException ex)
    	{
    		System.err.println(ex);
    	}
    	public void ice_exception(Ice.LocalException ex)
    	{
    		System.err.println(ex);
    	}
	}

	public static class AmdAmiCircularCallback extends Demo.AMI_Printer_amdAmiCircular {
    	public void ice_response()
    	{
            System.out.println("Client called Printer.amdAmiCircular_async... t=" + System.currentTimeMillis());
    	}
    	public void ice_exception(Ice.UserException ex)
    	{
    		System.err.println(ex);
    	}
    	public void ice_exception(Ice.LocalException ex)
    	{
    		System.err.println(ex);
    	}
	}


    public static class CircularCallback extends Demo.AMI_Printer_oldAmiCircular {
    	public void ice_response()
    	{
	    	System.out.println("ice_response");
    	}
    	public void ice_exception(Ice.UserException ex)
    	{
    		System.err.println(ex);
    	}
    	public void ice_exception(Ice.LocalException ex)
    	{
    		System.err.println(ex);
    	}
	}

}

