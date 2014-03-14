import java.util.concurrent.CountDownLatch;


public class TestProxyConcurrencyClient {
	
	private static String[] args;
	private static CountDownLatch latch;
	
    public static void main(String[] args) {
    	TestProxyConcurrencyClient.args = args;

    	latch = new CountDownLatch(1);
    	
    	for (int i=0; i<100; i++) {
	    	Runnable r = new Runnable() {
		    	public void run() {
		    		try {
		    			latch.await();
		    		}
		    		catch (InterruptedException e) {}

		    		makeCall();
		    	}
	    	};
	    	new Thread(r).start();
    	}

    	latch.countDown();
    	
    	try {Thread.sleep(120000);} catch (Exception e) {}    	
        System.exit(-1);
    }
    
    private static void makeCall() {
    	System.out.println("Entering Client.run");
    	
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("SimplePrinter:default -p 10000");
            Demo.PrinterPrx printer = Demo.PrinterPrxHelper.checkedCast(base);
            System.out.println("Calling initiateMarshalledProxyCallbackTest...");
            printer.initiateMarshalledProxyCallbackTest();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {ic.destroy();} catch (Exception e) {}
        }    	
    }
}

