// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package o:
//            bs, _cls09A8

public interface ci
{

    public abstract void begin();

    public abstract void connect();

    public abstract void disconnect();

    public abstract String getName();

    public abstract void _mth02C1(int i);

    public abstract bs _mth02CA(bs bs);

    public abstract void _mth02CA(ConnectionResult connectionresult, _cls09A8 _pcls09a8, int i);

    public abstract bs _mth02CB(bs bs);

    public abstract void _mth141D(Bundle bundle);
}
