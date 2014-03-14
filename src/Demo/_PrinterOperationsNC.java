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

public interface _PrinterOperationsNC
{
    void oldAmiPrintString(String s);

    void oldAmiCircular(String s, int level);

    void amdPrintString_async(AMD_Printer_amdPrintString __cb, String s);

    void amdCircular_async(AMD_Printer_amdCircular __cb, String s, int level);

    void amdAppThreadCircular_async(AMD_Printer_amdAppThreadCircular __cb, String s, int level);

    void printString(String s);

    void circular(String s, int level);

    void initiateMarshalledProxyCallbackTest();
}
