// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            arq, aey

final class afb extends arq
{

    private aey big;

    afb(aey aey1)
    {
        big = aey1;
        super();
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        big.setCommentSendOrClose();
    }
}
