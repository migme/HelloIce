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

public abstract class _PrinterDisp extends Ice.ObjectImpl implements Printer
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Demo::Printer",
        "::Ice::Object"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[0];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[0];
    }

    public static String
    ice_staticId()
    {
        return __ids[0];
    }

    public final void
    amdAppThreadCircular_async(AMD_Printer_amdAppThreadCircular __cb, String s, int level)
    {
        amdAppThreadCircular_async(__cb, s, level, null);
    }

    public final void
    amdCircular_async(AMD_Printer_amdCircular __cb, String s, int level)
    {
        amdCircular_async(__cb, s, level, null);
    }

    public final void
    amdPrintString_async(AMD_Printer_amdPrintString __cb, String s)
    {
        amdPrintString_async(__cb, s, null);
    }

    public final void
    callMeBack()
    {
        callMeBack(null);
    }

    public final void
    circular(String s, int level)
    {
        circular(s, level, null);
    }

    public final void
    initiateMarshalledProxyCallbackTest()
    {
        initiateMarshalledProxyCallbackTest(null);
    }

    public final void
    oldAmiCircular(String s, int level)
    {
        oldAmiCircular(s, level, null);
    }

    public final void
    oldAmiPrintString(String s)
    {
        oldAmiPrintString(s, null);
    }

    public final void
    printString(String s)
    {
        printString(s, null);
    }

    public static Ice.DispatchStatus
    ___oldAmiPrintString(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String s;
        s = __is.readString();
        __is.endReadEncaps();
        __obj.oldAmiPrintString(s, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___oldAmiCircular(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String s;
        s = __is.readString();
        int level;
        level = __is.readInt();
        __is.endReadEncaps();
        __obj.oldAmiCircular(s, level, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___amdPrintString(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String s;
        s = __is.readString();
        __is.endReadEncaps();
        AMD_Printer_amdPrintString __cb = new _AMD_Printer_amdPrintString(__inS);
        try
        {
            __obj.amdPrintString_async(__cb, s, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus
    ___amdCircular(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String s;
        s = __is.readString();
        int level;
        level = __is.readInt();
        __is.endReadEncaps();
        AMD_Printer_amdCircular __cb = new _AMD_Printer_amdCircular(__inS);
        try
        {
            __obj.amdCircular_async(__cb, s, level, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus
    ___amdAppThreadCircular(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String s;
        s = __is.readString();
        int level;
        level = __is.readInt();
        __is.endReadEncaps();
        AMD_Printer_amdAppThreadCircular __cb = new _AMD_Printer_amdAppThreadCircular(__inS);
        try
        {
            __obj.amdAppThreadCircular_async(__cb, s, level, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus
    ___printString(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String s;
        s = __is.readString();
        __is.endReadEncaps();
        __obj.printString(s, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___circular(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String s;
        s = __is.readString();
        int level;
        level = __is.readInt();
        __is.endReadEncaps();
        __obj.circular(s, level, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___initiateMarshalledProxyCallbackTest(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        __obj.initiateMarshalledProxyCallbackTest(__current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___callMeBack(Printer __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        __obj.callMeBack(__current);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "amdAppThreadCircular",
        "amdCircular",
        "amdPrintString",
        "callMeBack",
        "circular",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "initiateMarshalledProxyCallbackTest",
        "oldAmiCircular",
        "oldAmiPrintString",
        "printString"
    };

    public Ice.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___amdAppThreadCircular(this, in, __current);
            }
            case 1:
            {
                return ___amdCircular(this, in, __current);
            }
            case 2:
            {
                return ___amdPrintString(this, in, __current);
            }
            case 3:
            {
                return ___callMeBack(this, in, __current);
            }
            case 4:
            {
                return ___circular(this, in, __current);
            }
            case 5:
            {
                return ___ice_id(this, in, __current);
            }
            case 6:
            {
                return ___ice_ids(this, in, __current);
            }
            case 7:
            {
                return ___ice_isA(this, in, __current);
            }
            case 8:
            {
                return ___ice_ping(this, in, __current);
            }
            case 9:
            {
                return ___initiateMarshalledProxyCallbackTest(this, in, __current);
            }
            case 10:
            {
                return ___oldAmiCircular(this, in, __current);
            }
            case 11:
            {
                return ___oldAmiPrintString(this, in, __current);
            }
            case 12:
            {
                return ___printString(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type Demo::Printer was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type Demo::Printer was not generated with stream support";
        throw ex;
    }
}
