import java.util.concurrent.CountDownLatch;

import Demo.PrinterPrx;

public class MarshalledProxyCallbackTestI extends Demo._MarshalledProxyCallbackTestDisp {

    public void doMarshalledProxyCallbackTest(final PrinterPrx callMeBack, final Ice.Current current) {

    	final CountDownLatch latch = new CountDownLatch(1);

    	for (int i=0; i<100; i++) {
	    	Runnable r = new Runnable() {
		    	public void run() {
		    		try {
		    			latch.await();
		    		}
		    		catch (InterruptedException e) {}
		    		
		    		callMeBack.callMeBack();
		    	}
	    	};
	    	new Thread(r).start();
    	}

    	latch.countDown();
	}
    
}

