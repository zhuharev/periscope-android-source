// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.spongycastle.util.encoders.Base64;

// Referenced classes of package o:
//            acc, it, kd, iq, 
//            iw, FF6A, abk, aui

public final class abq
    implements acc
{

    private it bcA;

    public abq(it it1)
    {
        bcA = it1;
    }

    public final byte[] aA()
    {
        Object obj;
        ByteArrayOutputStream bytearrayoutputstream;
        DataOutputStream dataoutputstream;
        obj = new ArrayList(bcA.GC.entrySet().size());
        for (Iterator iterator = bcA.GC.entrySet().iterator(); iterator.hasNext(); ((ArrayList) (obj)).add(((java.util.Map.Entry)iterator.next()).getKey())) { }
        Collections.sort(((java.util.List) (obj)), String.CASE_INSENSITIVE_ORDER);
        bytearrayoutputstream = new ByteArrayOutputStream();
        dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        Iterator iterator1 = ((ArrayList) (obj)).iterator();
_L6:
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_295;
            }
            obj = (String)iterator1.next();
        } while (((String) (obj)).startsWith("signature") || ((String) (obj)).startsWith("signer_"));
        obj = (iq)bcA.GC.get(obj);
        if (!(obj instanceof iw)) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof iw)) goto _L4; else goto _L3
_L3:
        iw iw1 = (iw)obj;
          goto _L5
_L4:
        throw new IllegalStateException("This is not a JSON Primitive.");
_L5:
        if (iw1.value instanceof String)
        {
            obj = ((iq) (obj))._mth04AE();
            break MISSING_BLOCK_LABEL_211;
        }
_L2:
        obj = ((iq) (obj)).toString();
        dataoutputstream.write(((String) (obj)).getBytes(Charset.forName("UTF-8")));
          goto _L6
        IOException ioexception;
        ioexception;
        if (FF6A.mb)
        {
            Log.wtf("ChannelItem", "Should never happen", ioexception);
        }
        boolean flag;
        if ("RTMP".equals("ChannelItem") && FF6A.ma.get() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((abk)FF6A.ma.get()).log("Should never happen");
        }
        return bytearrayoutputstream.toByteArray();
    }

    public final byte[] aB()
    {
        iq iq1 = (iq)bcA.GC.get("signature");
        if (iq1 != null && aui._mth02BF(iq1._mth04AE()))
        {
            return Base64._mth1508(iq1._mth04AE());
        } else
        {
            return null;
        }
    }
}
