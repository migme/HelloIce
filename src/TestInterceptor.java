// TestInterceptor.java

import Ice.Current;
import Ice.DispatchStatus;
import Ice.Request;

public class TestInterceptor {

	/*extends Ice.DispatchInterceptor {

	private Ice.Object servant;
	
	public TestInterceptor(Ice.Object servant) {
		this.servant = servant;
	}
	
	@Override
	public DispatchStatus dispatch(Request request) {

		System.out.println("*** DISPATCHING CALL " + request.toString());
		
        Ice.Current current = request.getCurrent();
        
        Ice.ObjectAdapter oa = request.getCurrent().adapter;
        System.out.println("ObjectAdapter = " + oa);
        System.out.println("ObjectAdapter.hc = " + oa.hashCode());
        
        Ice.ObjectAdapterI oai = (Ice.ObjectAdapterI)oa;
        IceInternal.ThreadPool pool = oai.getThreadPool();
        System.out.println("pool=" + pool);
        
        return servant.ice_dispatch(request, null);
        */
	

}

