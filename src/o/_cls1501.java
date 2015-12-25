// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;

// Referenced classes of package o:
//            _cls05D7, FEAE, _cls0645

final class _cls1501
{

    private final _cls05D7 oj = new _cls05D7(1000);

    _cls1501()
    {
    }

    public final String _mth02BD(FEAE feae)
    {
        Object obj = oj;
        obj;
        JVM INSTR monitorenter ;
        String s = (String)oj.si.get(feae);
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        feae;
        throw feae;
_L1:
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        obj = MessageDigest.getInstance("SHA-256");
        feae._mth02CA(((MessageDigest) (obj)));
        obj = _cls0645._mth141D(((MessageDigest) (obj)).digest());
        s = ((String) (obj));
        break MISSING_BLOCK_LABEL_75;
        Object obj1;
        obj1;
        ((UnsupportedEncodingException) (obj1)).printStackTrace();
        break MISSING_BLOCK_LABEL_75;
        obj1;
        ((NoSuchAlgorithmException) (obj1)).printStackTrace();
        obj1 = oj;
        obj1;
        JVM INSTR monitorenter ;
        oj.put(feae, s);
        obj1;
        JVM INSTR monitorexit ;
        return s;
        feae;
        throw feae;
        return s;
    }
}
