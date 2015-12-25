// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


final class nj
    implements Runnable
{

    private ne._cls141D Lv;

    nj(ne._cls141D _pcls141d)
    {
        Lv = _pcls141d;
        super();
    }

    public final void run()
    {
        Lv.sendEmptyMessage(1);
    }
}
