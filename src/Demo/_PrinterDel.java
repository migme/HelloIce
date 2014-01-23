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

public interface _PrinterDel extends Ice._ObjectDel
{
    void oldAmiPrintString(String s, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void oldAmiCircular(String s, int level, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void amdPrintString(String s, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void amdCircular(String s, int level, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
