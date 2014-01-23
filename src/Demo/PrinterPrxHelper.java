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

public final class PrinterPrxHelper extends Ice.ObjectPrxHelperBase implements PrinterPrx
{
    public void
    amdCircular(String s, int level)
    {
        amdCircular(s, level, null, false);
    }

    public void
    amdCircular(String s, int level, java.util.Map<String, String> __ctx)
    {
        amdCircular(s, level, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    amdCircular(String s, int level, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _PrinterDel __del = (_PrinterDel)__delBase;
                __del.amdCircular(s, level, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex, null);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public void
    amdPrintString(String s)
    {
        amdPrintString(s, null, false);
    }

    public void
    amdPrintString(String s, java.util.Map<String, String> __ctx)
    {
        amdPrintString(s, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    amdPrintString(String s, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _PrinterDel __del = (_PrinterDel)__delBase;
                __del.amdPrintString(s, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex, null);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public void
    oldAmiCircular(String s, int level)
    {
        oldAmiCircular(s, level, null, false);
    }

    public void
    oldAmiCircular(String s, int level, java.util.Map<String, String> __ctx)
    {
        oldAmiCircular(s, level, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    oldAmiCircular(String s, int level, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _PrinterDel __del = (_PrinterDel)__delBase;
                __del.oldAmiCircular(s, level, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex, null);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public boolean
    oldAmiCircular_async(AMI_Printer_oldAmiCircular __cb, String s, int level)
    {
        return oldAmiCircular_async(__cb, s, level, null, false);
    }

    public boolean
    oldAmiCircular_async(AMI_Printer_oldAmiCircular __cb, String s, int level, java.util.Map<String, String> __ctx)
    {
        return oldAmiCircular_async(__cb, s, level, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private boolean
    oldAmiCircular_async(AMI_Printer_oldAmiCircular __cb, String s, int level, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx &&  __ctx == null)
        {
            __ctx = _emptyContext;
        }
        return __cb.__invoke(this, __cb, s, level, __ctx);
    }

    public void
    oldAmiPrintString(String s)
    {
        oldAmiPrintString(s, null, false);
    }

    public void
    oldAmiPrintString(String s, java.util.Map<String, String> __ctx)
    {
        oldAmiPrintString(s, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    oldAmiPrintString(String s, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _PrinterDel __del = (_PrinterDel)__delBase;
                __del.oldAmiPrintString(s, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex, null);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public boolean
    oldAmiPrintString_async(AMI_Printer_oldAmiPrintString __cb, String s)
    {
        return oldAmiPrintString_async(__cb, s, null, false);
    }

    public boolean
    oldAmiPrintString_async(AMI_Printer_oldAmiPrintString __cb, String s, java.util.Map<String, String> __ctx)
    {
        return oldAmiPrintString_async(__cb, s, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private boolean
    oldAmiPrintString_async(AMI_Printer_oldAmiPrintString __cb, String s, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx &&  __ctx == null)
        {
            __ctx = _emptyContext;
        }
        return __cb.__invoke(this, __cb, s, __ctx);
    }

    public static PrinterPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        PrinterPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (PrinterPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::Demo::Printer"))
                {
                    PrinterPrxHelper __h = new PrinterPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static PrinterPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        PrinterPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (PrinterPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::Demo::Printer", __ctx))
                {
                    PrinterPrxHelper __h = new PrinterPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static PrinterPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        PrinterPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::Demo::Printer"))
                {
                    PrinterPrxHelper __h = new PrinterPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static PrinterPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        PrinterPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::Demo::Printer", __ctx))
                {
                    PrinterPrxHelper __h = new PrinterPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static PrinterPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        PrinterPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (PrinterPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                PrinterPrxHelper __h = new PrinterPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static PrinterPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        PrinterPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            PrinterPrxHelper __h = new PrinterPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _PrinterDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _PrinterDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, PrinterPrx v)
    {
        __os.writeProxy(v);
    }

    public static PrinterPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            PrinterPrxHelper result = new PrinterPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
