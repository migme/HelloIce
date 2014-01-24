
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrinterI extends Demo._PrinterDisp {

	private ThreadPoolExecutor pool;
	private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
	
	public PrinterI() {
		pool = new ThreadPoolExecutor(100,200,24,TimeUnit.HOURS,queue);
	}
	
    public void oldAmiPrintString(String s, Ice.Current current) {
        System.out.println("\n Entering PrinterI.oldAmiPrintString... t=" + System.currentTimeMillis());
        printStringCommon(s,current);        
        System.out.println("Exiting PrinterI.oldAmiPrintString... t=" + System.currentTimeMillis());
    }

    public void oldAmiCircular(String s, int level, Ice.Current current) {
        System.out.println("\n Entering PrinterI.oldAmiCircular.. t=" + System.currentTimeMillis() +
        		"level=" + level);

        Demo.PrinterPrx printer = Server.getPrinterPrx();
        if (level==0) {
	        System.out.println("oldAmiCircular -> oldAmiPrintString");
            printer.oldAmiPrintString_async(new Client.PrintStringCallback(), s);
	        System.out.println("Done oldAmiCircular -> oldAmiPrintString");
        }
        else {
        	level--;
	        System.out.println("oldAmiCircular -> oldAmiCircular, level=" + level);
            printer.oldAmiCircular_async(new Client.CircularCallback(), s, level);
	        System.out.println("Done oldAmiCircular -> oldAmiCircular, level=" + level);        	
        }

        System.out.println("Exiting PrinterI.oldAmiCircular... t=" + System.currentTimeMillis());
    }

    
    public void amdPrintString_async(Demo.AMD_Printer_amdPrintString cb,String s, Ice.Current current) {
        System.out.println("\n Entering PrinterI.amdPrintString... t=" + System.currentTimeMillis());
    	System.out.println("Current.con=" + current.con);

        cb.ice_response();

        printStringCommon(s,current);        
        System.out.println("Exiting PrinterI.amdPrintString... t=" + System.currentTimeMillis());        
    }

    public void amdCircular_async(Demo.AMD_Printer_amdCircular cb,String s,int level,Ice.Current current) {
        System.out.println("\n Entering PrinterI.amdCircular_async, level==" + level +
        		"... t=" + System.currentTimeMillis());
    	System.out.println("Current.con=" + current.con);
        System.out.println("Current thread=" + Thread.currentThread().getName());
        System.out.println("Current thread group=" + Thread.currentThread().getThreadGroup().getName());

        cb.ice_response();

        Demo.PrinterPrx printer = Server.getPrinterPrx();
        if (level==0) {
	        System.out.println("amdCircular -> amdPrintString");
	        printer.amdPrintString(s);
	        System.out.println("Done amdCircular -> amdPrintString");
        }
        else {
        	level--;
	        System.out.println("amdCircular -> amdCircular, level=" + level);
	        printer.amdCircular(s, level);
	        System.out.println("Done amdCircular -> amdCircular, level=" + level);        	
        }
        
        System.out.println("Exiting PrinterI.amdCircular_async... t=" + System.currentTimeMillis());        
    }

    
    public void amdAppThreadCircular_async(final Demo.AMD_Printer_amdAppThreadCircular cb, final String s,final int level,Ice.Current current) {
    	pool.execute(new Runnable() {
    		public void run() {
                Demo.PrinterPrx printer = Server.getPrinterPrx();
                if (level==0) {
        	        System.out.println(s);
                }
                else {
                	int newLevel = level-1;
        	        System.out.println("amdAppThreadCircular -> amdAppThreadCircular, level=" + newLevel);
        	        System.out.flush();
        	        printer.amdAppThreadCircular(s, newLevel);
        	        System.out.println("Done amdAppThreadCircular -> amdAppThreadCircular, level=" + newLevel);        	
        	        System.out.flush();
                }
            	
                cb.ice_response();
    		}
    	});
    }

    
	public void printString(String s, Ice.Current current) {
        System.out.println("\n Entering PrinterI.printString... t=" + System.currentTimeMillis());
    	System.out.println("Current.con=" + current.con);
    	System.out.flush();

        printStringCommon(s,current);        
        System.out.println("Exiting PrinterI.printString... t=" + System.currentTimeMillis());        
	}
	
	public void circular(String s, int level, Ice.Current current) {
        Demo.PrinterPrx printer = Server.getPrinterPrx();
        if (level==0) {
        	printer.printString(s);
        }
        else {
        	int newLevel = level-1;
	        System.out.println("circular -> circular, level=" + newLevel);
	        System.out.flush();
	        printer.circular(s, newLevel);
	        System.out.println("Done circular -> circular, level=" + newLevel);        	
	        System.out.flush();
        }
	}
	
    private void printStringCommon(String s, Ice.Current current) {

    	final boolean INTERCEPTOR_ON = false;
    	if (INTERCEPTOR_ON) {
	    	System.out.println();
	    	System.out.println("##########################################################");
	    	System.out.println("Current.con=" + current.con);
	    	System.out.println("Current.facet=" + current.facet);
	    	System.out.println("Current.mode=" + current.mode);
	    	
	    	System.out.println("Current.ctx=");
	    	Set<String> keys = current.ctx.keySet();
	    	for (String key:keys) {
	    		System.out.println(key + "=" + current.ctx.get(key));
	    	}
	        
	    	// current.adapter.
	    	// System.out.println("Current.con." + current.)
	        // System.out.println(s);
	        /* Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
	        Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
	        for (Thread t:threadArray) {
	        	System.out.println(t);
	        } */
    	}

        System.out.println("Current thread=" + Thread.currentThread().getName());
        System.out.println("Current thread group=" + Thread.currentThread().getThreadGroup().getName());

    	System.out.println("PrinterI prints: " + s);

        try {
        	Thread.sleep(1000);
        }
        catch (Exception e) {}    	
    }
}

