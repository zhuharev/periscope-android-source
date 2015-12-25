// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package o:
//            os, or, nw

abstract class oq
{

    private byte MK[];
    private byte ML[];
    private boolean MM;
    private String Ml;
    private String Mm;

    public oq(String s, String s1)
    {
        MK = null;
        ML = null;
        Mm = "0123456789012345";
        MM = false;
        if (s1 != null)
        {
            Mm = s1;
        }
        Ml = s;
    }

    public static byte[] _mth02BD(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(Integer.toString((abyte0[i] & 0xff) + 256, 16).substring(1));
        }

        try
        {
            abyte0 = stringbuffer.toString().getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0 = abyte0.toString();
            throw new os(or._mth02CA(or.Nl, 12, abyte0));
        }
        return abyte0;
    }

    private static byte[] _mth037A(byte abyte0[])
    {
        try
        {
            abyte0 = MessageDigest.getInstance("SHA-256").digest(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0 = abyte0.toString();
            throw new os(or._mth02CA(or.Nl, 1111, abyte0));
        }
        return abyte0;
    }

    public static byte[] _mth1D57(String s)
    {
        try
        {
            s = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 118, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 119, s));
        }
        return s;
    }

    public String _mth1D40(String s)
    {
        try
        {
            FB9E();
            IvParameterSpec ivparameterspec = new IvParameterSpec(ML);
            SecretKeySpec secretkeyspec = new SecretKeySpec(MK, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretkeyspec, ivparameterspec);
            s = new String(cipher.doFinal(nw._mth1508(s)), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 111, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 112, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 113, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 114, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 115, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 116, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 117, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 118, s));
        }
        return s;
    }

    public String _mth1D4B(String s)
    {
        try
        {
            FB9E();
            IvParameterSpec ivparameterspec = new IvParameterSpec(ML);
            SecretKeySpec secretkeyspec = new SecretKeySpec(MK, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretkeyspec, ivparameterspec);
            s = new String(nw._mth02BC(cipher.doFinal(s.getBytes("UTF-8"))));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 13, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 14, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 15, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 16, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 17, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 18, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.toString();
            throw new os(or._mth02CA(or.Nl, 19, s));
        }
        return s;
    }

    public void FB9E()
    {
        if (MM)
        {
            return;
        }
        String s;
        try
        {
            MK = (new String(_mth02BD(_mth037A(Ml.getBytes("UTF-8"))), "UTF-8")).substring(0, 32).toLowerCase().getBytes("UTF-8");
            ML = Mm.getBytes("UTF-8");
            MM = true;
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            s = unsupportedencodingexception.toString();
        }
        throw new os(or._mth02CA(or.Nl, 11, s));
    }
}
