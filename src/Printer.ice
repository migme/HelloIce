module Demo {
    interface Printer {

        ["ami"] void oldAmiPrintString(string s);
        ["ami"] void oldAmiCircular(string s, int level);

        ["amd"] void amdPrintString(string s);
        ["amd"] void amdCircular(string s, int level);

        ["amd", "ami"] void amdAmiPrintString(string s);
        ["amd", "ami"] void amdAmiCircular(string s, int level);

        ["amd"] void amdAppThreadCircular(string s, int level);
        
		void printString(string s);
		void circular(string s, int level);

        /// void printString(string s);
        
        void initiateMarshalledProxyCallbackTest();
		void callMeBack(string s);
		void callMeBack2(string s);
    };
    
    interface MarshalledProxyCallbackTest {
    	void doMarshalledProxyCallbackTest(Printer* callMeBack);
    };
};


