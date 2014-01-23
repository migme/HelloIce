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

final class _AMD_Printer_amdCircular extends IceInternal.IncomingAsync implements AMD_Printer_amdCircular
{
    public
    _AMD_Printer_amdCircular(IceInternal.Incoming in)
    {
        super(in);
    }

    public void
    ice_response()
    {
        if(__validateResponse(true))
        {
            __response(true);
        }
    }

    public void
    ice_exception(java.lang.Exception ex)
    {
        if(__validateException(ex))
        {
            __exception(ex);
        }
    }
}
