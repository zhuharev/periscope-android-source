// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.GZIPInputStream;

// Referenced classes of package o:
//            ny, iu, iv, iq, 
//            os, it, kd, or, 
//            aul, ob

final class nz extends ny
{

    private int LW;
    private int LX;
    private HttpURLConnection connection;

    public nz(int i, int j, Hashtable hashtable)
    {
        LW = 0x4baf0;
        LX = 5000;
        HttpURLConnection.setFollowRedirects(true);
        LW = j;
        LX = i;
        LV = hashtable;
    }

    private static void _mth02CA(String s, or or1, or or2)
    {
        try
        {
            it it1 = (new iv())._mth02CA(new StringReader(s))._mth0673();
            throw new os(or._mth02CA(or1, ((iq)it1.GC.get("message"))._mth04AE(), ((iq)it1.GC.get("payload"))._mth0673()));
        }
        // Misplaced declaration of an exception variable
        catch (or or1)
        {
            throw new os(or._mth02CA(or2, s));
        }
    }

    private static String _mth02CB(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        for (int i = inputstream.read(abyte0); i != -1; i = inputstream.read(abyte0))
        {
            bytearrayoutputstream.write(abyte0, 0, i);
        }

        return new String(bytearrayoutputstream.toString());
    }

    public final void shutdown()
    {
        if (connection != null)
        {
            try
            {
                connection.disconnect();
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        } else
        {
            return;
        }
    }

    public final ob _mth02CA(String s, Hashtable hashtable)
    {
        this;
        JVM INSTR monitorenter ;
        aul._mth02BF("PubNub", (new StringBuilder("FETCHING URL : ")).append(s).toString());
        Object obj = new URL(s);
          goto _L1
_L18:
        throw new os(or._mth02CA(or.MT, s));
_L1:
        connection = (HttpURLConnection)((URL) (obj)).openConnection();
          goto _L2
_L19:
        throw new os(or._mth02CA(or.MV, s));
_L2:
        connection.setRequestMethod("GET");
          goto _L3
_L20:
        throw new os(or.MW);
_L3:
        if (LV != null)
        {
            String s1;
            String s3;
            for (obj = LV.keys(); ((Enumeration) (obj)).hasMoreElements(); connection.addRequestProperty(s1, s3))
            {
                s1 = (String)((Enumeration) (obj)).nextElement();
                s3 = (String)LV.get(s1);
            }

        }
        if (hashtable == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        String s2;
        String s4;
        for (obj = hashtable.keys(); ((Enumeration) (obj)).hasMoreElements(); connection.addRequestProperty(s2, s4))
        {
            s2 = (String)((Enumeration) (obj)).nextElement();
            s4 = (String)hashtable.get(s2);
        }

        connection.setReadTimeout(LW);
        connection.setConnectTimeout(LX);
        int i;
        i = connection.getResponseCode();
        break MISSING_BLOCK_LABEL_297;
        s;
        throw s;
        hashtable;
        throw new os(or._mth02CA(or.MX, (new StringBuilder()).append(s).append(" : ").append(hashtable.toString()).toString()));
        hashtable = connection.getContentEncoding();
        if (hashtable == null) goto _L5; else goto _L4
_L4:
        boolean flag = hashtable.equals("gzip");
        if (flag) goto _L6; else goto _L5
_L5:
        hashtable = connection.getInputStream();
          goto _L7
_L21:
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        throw new os(or._mth02CA(or.MY, 1, s));
        hashtable = connection.getErrorStream();
          goto _L7
_L6:
        hashtable = new GZIPInputStream(connection.getInputStream());
          goto _L7
_L22:
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_410;
        }
        throw new os(or._mth02CA(or.MY, 2, s));
        hashtable = connection.getErrorStream();
_L7:
        obj = _mth02CB(hashtable);
          goto _L8
_L23:
        throw new os(or._mth02CA(or.MZ, s));
_L8:
        if (hashtable == null)
        {
            break MISSING_BLOCK_LABEL_449;
        }
        try
        {
            hashtable.close();
        }
        // Misplaced declaration of an exception variable
        catch (Hashtable hashtable) { }
        aul._mth02BF("PubNub", (new StringBuilder("URL = ")).append(s).append(", Status Code : ").append(i).append(", : RESPONSE = ").append(((String) (obj))).toString());
        i;
        JVM INSTR lookupswitch 8: default 735
    //                   400: 584
    //                   401: 574
    //                   403: 564
    //                   404: 594
    //                   408: 619
    //                   500: 649
    //                   502: 604
    //                   504: 634;
           goto _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L12:
        _mth02CA(((String) (obj)), or.Nh, or.Nh);
_L11:
        _mth02CA(((String) (obj)), or.Nh, or.Ni);
_L10:
        _mth02CA(((String) (obj)), or.Na, or.Na);
_L13:
        _mth02CA(((String) (obj)), or.Na, or.Nj);
_L16:
        throw new os(or._mth02CA(or.Nc, s));
_L14:
        throw new os(or._mth02CA(or.Nd, s));
_L17:
        throw new os(or._mth02CA(or.Ne, s));
_L15:
        throw new os(or._mth02CA(or.MO, (new StringBuilder()).append(s).append(" : ").append(i).toString()));
_L9:
        s = new ob(i, ((String) (obj)));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
        hashtable;
          goto _L18
        hashtable;
          goto _L19
        s;
          goto _L20
        hashtable;
          goto _L21
        hashtable;
          goto _L22
        hashtable;
          goto _L23
    }
}
