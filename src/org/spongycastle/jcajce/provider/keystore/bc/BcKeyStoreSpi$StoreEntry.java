// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.keystore.bc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.util.Date;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

// Referenced classes of package org.spongycastle.jcajce.provider.keystore.bc:
//            BcKeyStoreSpi

class aEZ
{

    String aEY;
    Certificate aEZ[];
    Date aFa;
    private BcKeyStoreSpi aFb;
    Object obj;
    int type;

    final Object _mth141D(char ac[])
    {
        if ((ac == null || ac.length == 0) && (obj instanceof Key))
        {
            return obj;
        }
        if (type != 4) goto _L2; else goto _L1
_L1:
        Object obj1 = new DataInputStream(new ByteArrayInputStream((byte[])obj));
        byte abyte1[];
        ByteArrayOutputStream bytearrayoutputstream;
        DataOutputStream dataoutputstream;
        int i;
        try
        {
            byte abyte0[] = new byte[((DataInputStream) (obj1)).readInt()];
            ((DataInputStream) (obj1)).readFully(abyte0);
            obj1 = new CipherInputStream(((java.io.InputStream) (obj1)), BcKeyStoreSpi._mth02CA("PBEWithSHAAnd3-KeyTripleDES-CBC", 2, ac, abyte0, ((DataInputStream) (obj1)).readInt()));
        }
        // Misplaced declaration of an exception variable
        catch (char ac[])
        {
            throw new UnrecoverableKeyException("no match");
        }
        obj1 = BcKeyStoreSpi._mth02CA(aFb, new DataInputStream(((java.io.InputStream) (obj1))));
        return obj1;
_L4:
        obj1 = new DataInputStream(new ByteArrayInputStream((byte[])obj));
        abyte1 = new byte[((DataInputStream) (obj1)).readInt()];
        ((DataInputStream) (obj1)).readFully(abyte1);
        i = ((DataInputStream) (obj1)).readInt();
        obj1 = new CipherInputStream(((java.io.InputStream) (obj1)), BcKeyStoreSpi._mth02CA("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, ac, abyte1, i));
        obj1 = BcKeyStoreSpi._mth02CA(aFb, new DataInputStream(((java.io.InputStream) (obj1))));
          goto _L3
_L5:
        obj1 = new DataInputStream(new ByteArrayInputStream((byte[])obj));
        abyte1 = new byte[((DataInputStream) (obj1)).readInt()];
        ((DataInputStream) (obj1)).readFully(abyte1);
        i = ((DataInputStream) (obj1)).readInt();
        obj1 = new CipherInputStream(((java.io.InputStream) (obj1)), BcKeyStoreSpi._mth02CA("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, ac, abyte1, i));
        obj1 = BcKeyStoreSpi._mth02CA(aFb, new DataInputStream(((java.io.InputStream) (obj1))));
_L3:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        bytearrayoutputstream = new ByteArrayOutputStream();
        dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        dataoutputstream.writeInt(abyte1.length);
        dataoutputstream.write(abyte1);
        dataoutputstream.writeInt(i);
        ac = new DataOutputStream(new CipherOutputStream(dataoutputstream, BcKeyStoreSpi._mth02CA("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, ac, abyte1, i)));
        BcKeyStoreSpi._mth02CA(aFb, ((Key) (obj1)), ac);
        ac.close();
        obj = bytearrayoutputstream.toByteArray();
        return obj1;
        throw new UnrecoverableKeyException("no match");
_L2:
        throw new RuntimeException("forget something!");
        Exception exception;
        exception;
          goto _L4
        exception;
          goto _L5
    }

    (BcKeyStoreSpi bckeystorespi, String s, Key key, char ac[], Certificate acertificate[])
    {
        aFb = bckeystorespi;
        super();
        aFa = new Date();
        type = 4;
        aEY = s;
        aEZ = acertificate;
        acertificate = new byte[20];
        bckeystorespi.amC.setSeed(System.currentTimeMillis());
        bckeystorespi.amC.nextBytes(acertificate);
        int i = (bckeystorespi.amC.nextInt() & 0x3ff) + 1024;
        s = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(s);
        dataoutputstream.writeInt(20);
        dataoutputstream.write(acertificate);
        dataoutputstream.writeInt(i);
        ac = new DataOutputStream(new CipherOutputStream(dataoutputstream, BcKeyStoreSpi._mth02CA("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, ac, acertificate, i)));
        BcKeyStoreSpi._mth02CA(bckeystorespi, key, ac);
        ac.close();
        obj = s.toByteArray();
    }

    obj(BcKeyStoreSpi bckeystorespi, String s, Certificate certificate)
    {
        aFb = bckeystorespi;
        super();
        aFa = new Date();
        type = 1;
        aEY = s;
        obj = certificate;
        aEZ = null;
    }

    aEZ(BcKeyStoreSpi bckeystorespi, String s, Date date, int i, Object obj1, Certificate acertificate[])
    {
        aFb = bckeystorespi;
        super();
        aFa = new Date();
        aEY = s;
        aFa = date;
        type = i;
        obj = obj1;
        aEZ = acertificate;
    }

    aEZ(BcKeyStoreSpi bckeystorespi, String s, Date date, int i, Certificate certificate)
    {
        aFb = bckeystorespi;
        super();
        aFa = new Date();
        aEY = s;
        aFa = date;
        type = 1;
        obj = certificate;
    }

    obj(BcKeyStoreSpi bckeystorespi, String s, byte abyte0[], Certificate acertificate[])
    {
        aFb = bckeystorespi;
        super();
        aFa = new Date();
        type = 3;
        aEY = s;
        obj = abyte0;
        aEZ = acertificate;
    }
}
