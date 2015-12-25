// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package o:
//            uk, um, ra, rl

public final class ul
    implements X509TrustManager
{

    private final TrustManager TK[];
    private final um TL;
    private final long TM;
    private final LinkedList TN = new LinkedList();
    private final Set TO = Collections.synchronizedSet(new HashSet());

    public ul(um um1, uk uk1)
    {
        TK = _mth02CA(um1);
        TL = um1;
        TM = uk1.getPinCreationTimeInMillis();
        um1 = uk1.getPins();
        int j = um1.length;
        for (int i = 0; i < j; i++)
        {
            uk1 = um1[i];
            TN.add(hexStringToByteArray(uk1));
        }

    }

    private static byte[] hexStringToByteArray(String s)
    {
        int j = s.length();
        byte abyte0[] = new byte[j / 2];
        for (int i = 0; i < j; i += 2)
        {
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return abyte0;
    }

    private boolean _mth02CA(X509Certificate x509certificate)
    {
        Iterator iterator;
        x509certificate = MessageDigest.getInstance("SHA1").digest(x509certificate.getPublicKey().getEncoded());
        iterator = TN.iterator();
_L1:
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        flag = Arrays.equals((byte[])iterator.next(), x509certificate);
        if (flag)
        {
            return true;
        }
          goto _L1
        return false;
        x509certificate;
        throw new CertificateException(x509certificate);
    }

    private static TrustManager[] _mth02CA(um um1)
    {
        try
        {
            TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance("X509");
            trustmanagerfactory.init(um1.TP);
            um1 = trustmanagerfactory.getTrustManagers();
        }
        // Misplaced declaration of an exception variable
        catch (um um1)
        {
            throw new AssertionError(um1);
        }
        // Misplaced declaration of an exception variable
        catch (um um1)
        {
            throw new AssertionError(um1);
        }
        return um1;
    }

    public final void checkClientTrusted(X509Certificate ax509certificate[], String s)
    {
        throw new CertificateException("Client certificates not supported!");
    }

    public final void checkServerTrusted(X509Certificate ax509certificate[], String s)
    {
label0:
        {
            if (TO.contains(ax509certificate[0]))
            {
                return;
            }
            TrustManager atrustmanager[] = TK;
            int k = atrustmanager.length;
            for (int i = 0; i < k; i++)
            {
                ((X509TrustManager)atrustmanager[i]).checkServerTrusted(ax509certificate, s);
            }

            if (TM != -1L && System.currentTimeMillis() - TM > 0x39ef8b000L)
            {
                ra._mth0454()._mth02CE("Fabric", (new StringBuilder("Certificate pins are stale, (")).append(System.currentTimeMillis() - TM).append(" millis vs 15552000000").append(" millis) falling back to system trust.").toString());
                break label0;
            }
            s = _cls141D.if._mth02CA(ax509certificate, TL);
            k = s.length;
            for (int j = 0; j < k; j++)
            {
                if (_mth02CA(s[j]))
                {
                    break label0;
                }
            }

            throw new CertificateException("No valid pins found in chain!");
        }
        TO.add(ax509certificate[0]);
    }

    public final X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}
