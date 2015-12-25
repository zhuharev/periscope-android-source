// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1UTCTime;

public class Time extends ASN1Object
    implements ASN1Choice
{

    public ASN1Primitive ajW;

    private Time(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1UTCTime) && !(asn1primitive instanceof ASN1GeneralizedTime))
        {
            throw new IllegalArgumentException("unknown object passed to Time");
        } else
        {
            ajW = asn1primitive;
            return;
        }
    }

    public static Time _mth02E1(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof Time))
        {
            return (Time)asn1encodable;
        }
        if (asn1encodable instanceof ASN1UTCTime)
        {
            return new Time((ASN1UTCTime)asn1encodable);
        }
        if (asn1encodable instanceof ASN1GeneralizedTime)
        {
            return new Time((ASN1GeneralizedTime)asn1encodable);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unknown object in factory: ")).append(asn1encodable.getClass().getName()).toString());
        }
    }

    public final Date getDate()
    {
        Object obj;
        if (!(ajW instanceof ASN1UTCTime))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        obj = (ASN1UTCTime)ajW;
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpledateformat.setTimeZone(new SimpleTimeZone(0, "Z"));
        obj = simpledateformat.parse(((ASN1UTCTime) (obj))._mth0695());
        return ((Date) (obj));
        Date date;
        try
        {
            date = ((ASN1GeneralizedTime)ajW).getDate();
        }
        catch (ParseException parseexception)
        {
            throw new IllegalStateException((new StringBuilder("invalid date string: ")).append(parseexception.getMessage()).toString());
        }
        return date;
    }

    public String toString()
    {
        if (ajW instanceof ASN1UTCTime)
        {
            return ((ASN1UTCTime)ajW)._mth0695();
        } else
        {
            return ((ASN1GeneralizedTime)ajW)._mth0437();
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return ajW;
    }
}
