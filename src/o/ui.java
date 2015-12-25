// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.HttpURLConnection;
import java.net.URL;

final class ui
    implements ug._cls02CB
{

    ui()
    {
    }

    public final HttpURLConnection _mth02CB(URL url)
    {
        return (HttpURLConnection)url.openConnection();
    }
}
