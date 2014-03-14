// **********************************************************************
//
// Copyright (c) 2003-2009 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.3.1

package Demo;

public interface PrinterPrx extends Ice.ObjectPrx
{
    public void oldAmiPrintString(String s);
    public void oldAmiPrintString(String s, java.util.Map<String, String> __ctx);

    public boolean oldAmiPrintString_async(AMI_Printer_oldAmiPrintString __cb, String s);
    public boolean oldAmiPrintString_async(AMI_Printer_oldAmiPrintString __cb, String s, java.util.Map<String, String> __ctx);

    public void oldAmiCircular(String s, int level);
    public void oldAmiCircular(String s, int level, java.util.Map<String, String> __ctx);

    public boolean oldAmiCircular_async(AMI_Printer_oldAmiCircular __cb, String s, int level);
    public boolean oldAmiCircular_async(AMI_Printer_oldAmiCircular __cb, String s, int level, java.util.Map<String, String> __ctx);

    public void amdPrintString(String s);
    public void amdPrintString(String s, java.util.Map<String, String> __ctx);

    public void amdCircular(String s, int level);
    public void amdCircular(String s, int level, java.util.Map<String, String> __ctx);

    public void amdAppThreadCircular(String s, int level);
    public void amdAppThreadCircular(String s, int level, java.util.Map<String, String> __ctx);

    public void printString(String s);
    public void printString(String s, java.util.Map<String, String> __ctx);

    public void circular(String s, int level);
    public void circular(String s, int level, java.util.Map<String, String> __ctx);

    public void initiateMarshalledProxyCallbackTest();
    public void initiateMarshalledProxyCallbackTest(java.util.Map<String, String> __ctx);

    public void callMeBack(String s);
    public void callMeBack(String s, java.util.Map<String, String> __ctx);

    public void callMeBack2(String s);
    public void callMeBack2(String s, java.util.Map<String, String> __ctx);
}
