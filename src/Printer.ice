module Demo {
    interface Printer {

        ["ami"] void oldAmiPrintString(string s);
        ["ami"] void oldAmiCircular(string s, int level);

        ["amd"] void amdPrintString(string s);
        ["amd"] void amdCircular(string s, int level);

        ["amd"] void amdAppThreadCircular(string s, int level);
        
        /// void printString(string s);
    };
};


