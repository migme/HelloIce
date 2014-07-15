package helloice;

public class Server {
	
    private static Ice.Communicator ic = null;
    
    public static synchronized Demo.PrinterPrx getPrinterPrx() {
        Ice.ObjectPrx base = Server.ic.stringToProxy(Constants.PRINTER_OBJECT_IDENTITY +":default -p " + Constants.PRINTER_ADAPTER_PORT);
        return Demo.PrinterPrxHelper.checkedCast(base);
    }

    public static synchronized Demo.MarshalledProxyCallbackTestPrx getMPCTPrx() {
        Ice.ObjectPrx base = Server.ic.stringToProxy(Constants.MPCT_OBJECT_IDENTITY +":default -p " + Constants.MPCT_ADAPTER_PORT);
        return Demo.MarshalledProxyCallbackTestPrxHelper.checkedCast(base);
    }

    public static void main(String[] args)
    {
        int status = 0;
        try {
        	
        	Ice.Properties properties = Ice.Util.createProperties();
        	
           	properties.setProperty("SimplePrinterAdapter.ThreadPool.Size", "2");
        	// properties.setProperty("Ice.ThreadPool.Client.Size", "2");
        	// properties.setProperty("Ice.ThreadPool.Client.SizeMax", "2");

        	/*
        	properties.setProperty("Ice.Default.CollocationOptimized", "0");
        	
        	final boolean LOW_THREADS = true;
        	if (LOW_THREADS) {
        		properties.setProperty("Ice.ThreadPool.Server.Size", "1");
        		properties.setProperty("Ice.ThreadPool.Server.SizeMax", "1");
        	}

        	properties.setProperty("Ice.Trace.Slicing", "1");
        	*/

        	Ice.InitializationData id = new Ice.InitializationData();
        	id.properties = properties;
        	
            ic = Ice.Util.initialize(id);
            
            createPrinterI();
            createMarshalledProxyCallbackTestI();
            
            ic.waitForShutdown();
        } catch (Exception e) {
            e.printStackTrace();
            status = 1;
        }

        if (ic != null) {
            try {ic.destroy();} catch (Exception e) {}
        }
        System.exit(status);
    }

    private static void createPrinterI() {
        Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints(
        		Constants.PRINTER_ADAPTER_NAME, "default -p " + Constants.PRINTER_ADAPTER_PORT);
        System.out.println("adapter=" + adapter);
        System.out.println("adapter.hc=" + adapter.hashCode());
        Ice.Object object = new PrinterI();
        
        final boolean INTERCEPTOR_ON = false;
        if (INTERCEPTOR_ON) {
        	// TestInterceptor interceptor = new TestInterceptor(object);
        	// objPrx = adapter.add(interceptor, ic.stringToIdentity("SimplePrinter"));
        }
        else {
        	Ice.ObjectPrx objPrx = adapter.add(object, ic.stringToIdentity(Constants.PRINTER_OBJECT_IDENTITY));
        }
                    
        adapter.activate();    	
    }

    private static void createMarshalledProxyCallbackTestI() {
        Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints(
        		Constants.MPCT_ADAPTER_NAME, "default -p " + Constants.MPCT_ADAPTER_PORT);
        Ice.Object object = new MarshalledProxyCallbackTestI();
        
        Ice.ObjectPrx objPrx = adapter.add(object, ic.stringToIdentity(Constants.MPCT_OBJECT_IDENTITY));
        adapter.activate();    	    	
    }
}

