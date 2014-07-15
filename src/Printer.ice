module Demo {
    interface Printer {

        ["ami"] void oldAmiPrintString(string s);
        ["ami"] void oldAmiCircular(string s, int level);

        ["amd"] void amdPrintString(string s);
        ["amd"] void amdCircular(string s, int level);

        ["amd"] void amdAppThreadCircular(string s, int level);
        
		void printString(string s);
		void circular(string s, int level);

        /// void printString(string s);
        
        void initiateMarshalledProxyCallbackTest();
		void callMeBack(string s);
		void callMeBack2(string s);
		
		// oneway proxies and connection pooling test
		void oneway();
		void blockForever();
    };
    
    interface MarshalledProxyCallbackTest {
    	void doMarshalledProxyCallbackTest(Printer* callMeBack);
    };
};


