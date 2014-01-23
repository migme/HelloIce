

public class Server {
	
    private static Ice.Communicator ic = null;
    
    public static synchronized Demo.PrinterPrx getPrinterPrx() {
        Ice.ObjectPrx base = Server.ic.stringToProxy("SimplePrinter:default -p 10000");
        return Demo.PrinterPrxHelper.checkedCast(base);
    }

    public static void main(String[] args)
    {
        int status = 0;
        try {
        	
        	Ice.Properties properties = Ice.Util.createProperties();
        	
           	///// properties.setProperty("SimplePrinterAdapter.ThreadPool.Size", "15");
        	// properties.setProperty("Ice.ThreadPool.Client.Size", "2");
        	// properties.setProperty("Ice.ThreadPool.Client.SizeMax", "2");

        	properties.setProperty("Ice.Default.CollocationOptimized", "0");
        	
        	final boolean LOW_THREADS = true;
        	if (LOW_THREADS) {
        		properties.setProperty("Ice.ThreadPool.Server.Size", "1");
        		properties.setProperty("Ice.ThreadPool.Server.SizeMax", "1");
        	}

        	properties.setProperty("Ice.Trace.Slicing", "1");

        	Ice.InitializationData id = new Ice.InitializationData();
        	id.properties = properties;
        	
            ic = Ice.Util.initialize(id);
            Ice.ObjectAdapter adapter =
                ic.createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -p 10000");
            System.out.println("adapter=" + adapter);
            System.out.println("adapter.hc=" + adapter.hashCode());
            Ice.Object object = new PrinterI();
            
            Ice.ObjectPrx objPrx;
            final boolean INTERCEPTOR_ON = false;
            if (INTERCEPTOR_ON) {
            	// TestInterceptor interceptor = new TestInterceptor(object);
            	// objPrx = adapter.add(interceptor, ic.stringToIdentity("SimplePrinter"));
            }
            else {
            	objPrx = adapter.add(object, ic.stringToIdentity("SimplePrinter"));
            }
                        
            adapter.activate();
            ic.waitForShutdown();
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
        System.exit(status);
    }
    
    /*
    private void makeTestCall(Ice.ObjectPrx objPrx) {
        System.out.println("Making call on objPrx");
        Demo.PrinterPrx printer = Demo.PrinterPrxHelper.checkedCast(objPrx);
        printer.printString("Called from Server.main");
        System.out.println("Made call on objPrx");    	
    }
    */
}

