// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, TlsFatalAlert, MaxFragmentLength

public class TlsExtensionsUtils
{

    private static Integer aBT = Integers.valueOf(22);
    private static Integer aBU = Integers.valueOf(1);
    public static final Integer aBV = Integers.valueOf(5);
    private static Integer aBW = Integers.valueOf(4);

    public TlsExtensionsUtils()
    {
    }

    public static Hashtable _mth02BF(Hashtable hashtable)
    {
        if (hashtable == null)
        {
            return new Hashtable();
        } else
        {
            return hashtable;
        }
    }

    public static short _mth02C8(Hashtable hashtable)
    {
        hashtable = TlsUtils._mth02CA(hashtable, aBU);
        if (hashtable == null)
        {
            return -1;
        }
        if (hashtable == null)
        {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (hashtable.length != 1)
        {
            throw new TlsFatalAlert((short)50);
        }
        short word0 = hashtable[0];
        if (!MaxFragmentLength._mth02CF(word0))
        {
            throw new TlsFatalAlert((short)47);
        } else
        {
            return word0;
        }
    }

    public static boolean _mth02C9(Hashtable hashtable)
    {
        hashtable = TlsUtils._mth02CA(hashtable, aBT);
        if (hashtable == null)
        {
            return false;
        }
        if (hashtable == null)
        {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (hashtable.length != 0)
        {
            throw new TlsFatalAlert((short)47);
        } else
        {
            return true;
        }
    }

    public static boolean _mth02CC(Hashtable hashtable)
    {
        hashtable = TlsUtils._mth02CA(hashtable, aBW);
        if (hashtable == null)
        {
            return false;
        }
        if (hashtable == null)
        {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        if (hashtable.length != 0)
        {
            throw new TlsFatalAlert((short)47);
        } else
        {
            return true;
        }
    }

    static 
    {
        Integers.valueOf(15);
        Integers.valueOf(0);
    }
}
