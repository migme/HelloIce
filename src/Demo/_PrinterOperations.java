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

public interface _PrinterOperations
{
    void oldAmiPrintString(String s, Ice.Current __current);

    void oldAmiCircular(String s, int level, Ice.Current __current);

    void amdPrintString_async(AMD_Printer_amdPrintString __cb, String s, Ice.Current __current);

    void amdCircular_async(AMD_Printer_amdCircular __cb, String s, int level, Ice.Current __current);

    void amdAppThreadCircular_async(AMD_Printer_amdAppThreadCircular __cb, String s, int level, Ice.Current __current);

    void printString(String s, Ice.Current __current);

    void circular(String s, int level, Ice.Current __current);

    void initiateMarshalledProxyCallbackTest(Ice.Current __current);
}
