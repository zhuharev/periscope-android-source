// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls03BD, ahz, _cls0EB2, aqd, 
//            _cls0192

final class <init> extends _cls03BD
{

    private ahz bmE;

    public final void _mth02CA(Object obj, _cls0192 _pcls0192)
    {
        obj = (_cls0EB2)obj;
        bmE.bmu.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
        if (bmE.bmC != null)
        {
            bmE.bmu.setColorFilter(bmE.bmC.intValue());
        }
    }

    private .Object(ahz ahz1)
    {
        bmE = ahz1;
        super();
    }

    nit>(ahz ahz1, byte byte0)
    {
        this(ahz1);
    }
}
