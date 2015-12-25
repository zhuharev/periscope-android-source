// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;


// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsClient, TlsDHKeyExchange, TlsDHEKeyExchange, TlsECDHKeyExchange, 
//            TlsECDHEKeyExchange, TlsRSAKeyExchange, TlsFatalAlert, TlsCipherFactory, 
//            TlsKeyExchange, TlsCipher

public abstract class DefaultTlsClient extends AbstractTlsClient
{

    public DefaultTlsClient()
    {
    }

    public final TlsKeyExchange _mth0693()
    {
        switch (azD)
        {
        case 13: // '\r'
        case 48: // '0'
        case 54: // '6'
        case 62: // '>'
        case 66: // 'B'
        case 104: // 'h'
        case 133: 
        case 151: 
        case 164: 
        case 165: 
        case 187: 
        case 193: 
        case 49282: 
        case 49283: 
            return new TlsDHKeyExchange(7, null, null);

        case 16: // '\020'
        case 49: // '1'
        case 55: // '7'
        case 63: // '?'
        case 67: // 'C'
        case 105: // 'i'
        case 134: 
        case 152: 
        case 160: 
        case 161: 
        case 188: 
        case 194: 
        case 49278: 
        case 49279: 
            return new TlsDHKeyExchange(9, null, null);

        case 19: // '\023'
        case 50: // '2'
        case 56: // '8'
        case 64: // '@'
        case 68: // 'D'
        case 106: // 'j'
        case 135: 
        case 153: 
        case 162: 
        case 163: 
        case 189: 
        case 195: 
        case 49280: 
        case 49281: 
            return new TlsDHEKeyExchange(3, null, null);

        case 22: // '\026'
        case 51: // '3'
        case 57: // '9'
        case 69: // 'E'
        case 103: // 'g'
        case 107: // 'k'
        case 136: 
        case 154: 
        case 158: 
        case 159: 
        case 190: 
        case 196: 
        case 49276: 
        case 49277: 
        case 49310: 
        case 49311: 
        case 49314: 
        case 49315: 
        case 52245: 
        case 58398: 
        case 58399: 
            return new TlsDHEKeyExchange(5, null, null);

        case 49153: 
        case 49154: 
        case 49155: 
        case 49156: 
        case 49157: 
        case 49189: 
        case 49190: 
        case 49197: 
        case 49198: 
        case 49268: 
        case 49269: 
        case 49288: 
        case 49289: 
            return new TlsECDHKeyExchange(16, null, null, null, azC);

        case 49163: 
        case 49164: 
        case 49165: 
        case 49166: 
        case 49167: 
        case 49193: 
        case 49194: 
        case 49201: 
        case 49202: 
        case 49272: 
        case 49273: 
        case 49292: 
        case 49293: 
            return new TlsECDHKeyExchange(18, null, null, null, azC);

        case 49158: 
        case 49159: 
        case 49160: 
        case 49161: 
        case 49162: 
        case 49187: 
        case 49188: 
        case 49195: 
        case 49196: 
        case 49266: 
        case 49267: 
        case 49286: 
        case 49287: 
        case 52244: 
        case 58388: 
        case 58389: 
            return new TlsECDHEKeyExchange(17, null, null, null, azC);

        case 49168: 
        case 49169: 
        case 49170: 
        case 49171: 
        case 49172: 
        case 49191: 
        case 49192: 
        case 49199: 
        case 49200: 
        case 49270: 
        case 49271: 
        case 49290: 
        case 49291: 
        case 52243: 
        case 58386: 
        case 58387: 
            return new TlsECDHEKeyExchange(19, null, null, null, azC);

        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        case 5: // '\005'
        case 10: // '\n'
        case 47: // '/'
        case 53: // '5'
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 65: // 'A'
        case 132: 
        case 150: 
        case 156: 
        case 157: 
        case 186: 
        case 192: 
        case 49274: 
        case 49275: 
        case 49308: 
        case 49309: 
        case 49312: 
        case 49313: 
        case 58384: 
        case 58385: 
            return new TlsRSAKeyExchange(null);
        }
        throw new TlsFatalAlert((short)80);
    }

    public final TlsCipher _mth06BD()
    {
        switch (azD)
        {
        case 10: // '\n'
        case 13: // '\r'
        case 16: // '\020'
        case 19: // '\023'
        case 22: // '\026'
        case 49155: 
        case 49160: 
        case 49165: 
        case 49170: 
            return azB._mth02CA(null, 7, 2);

        case 52243: 
        case 52244: 
        case 52245: 
            return azB._mth02CA(null, 102, 0);

        case 47: // '/'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 49156: 
        case 49161: 
        case 49166: 
        case 49171: 
            return azB._mth02CA(null, 8, 2);

        case 60: // '<'
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        case 103: // 'g'
        case 49187: 
        case 49189: 
        case 49191: 
        case 49193: 
            return azB._mth02CA(null, 8, 3);

        case 49308: 
        case 49310: 
            return azB._mth02CA(null, 15, 0);

        case 49312: 
        case 49314: 
            return azB._mth02CA(null, 16, 0);

        case 156: 
        case 158: 
        case 160: 
        case 162: 
        case 164: 
        case 49195: 
        case 49197: 
        case 49199: 
        case 49201: 
            return azB._mth02CA(null, 10, 0);

        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
        case 49157: 
        case 49162: 
        case 49167: 
        case 49172: 
            return azB._mth02CA(null, 9, 2);

        case 61: // '='
        case 104: // 'h'
        case 105: // 'i'
        case 106: // 'j'
        case 107: // 'k'
            return azB._mth02CA(null, 9, 3);

        case 49188: 
        case 49190: 
        case 49192: 
        case 49194: 
            return azB._mth02CA(null, 9, 4);

        case 49309: 
        case 49311: 
            return azB._mth02CA(null, 17, 0);

        case 49313: 
        case 49315: 
            return azB._mth02CA(null, 18, 0);

        case 157: 
        case 159: 
        case 161: 
        case 163: 
        case 165: 
        case 49196: 
        case 49198: 
        case 49200: 
        case 49202: 
            return azB._mth02CA(null, 11, 0);

        case 65: // 'A'
        case 66: // 'B'
        case 67: // 'C'
        case 68: // 'D'
        case 69: // 'E'
            return azB._mth02CA(null, 12, 2);

        case 186: 
        case 187: 
        case 188: 
        case 189: 
        case 190: 
        case 49266: 
        case 49268: 
        case 49270: 
        case 49272: 
            return azB._mth02CA(null, 12, 3);

        case 49274: 
        case 49276: 
        case 49278: 
        case 49280: 
        case 49282: 
        case 49286: 
        case 49288: 
        case 49290: 
        case 49292: 
            return azB._mth02CA(null, 19, 0);

        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
            return azB._mth02CA(null, 13, 2);

        case 192: 
        case 193: 
        case 194: 
        case 195: 
        case 196: 
            return azB._mth02CA(null, 13, 3);

        case 49275: 
        case 49277: 
        case 49279: 
        case 49281: 
        case 49283: 
        case 49287: 
        case 49289: 
        case 49291: 
        case 49293: 
            return azB._mth02CA(null, 20, 0);

        case 49267: 
        case 49269: 
        case 49271: 
        case 49273: 
            return azB._mth02CA(null, 13, 4);

        case 58384: 
        case 58386: 
        case 58388: 
        case 58398: 
            return azB._mth02CA(null, 100, 2);

        case 1: // '\001'
            return azB._mth02CA(null, 0, 1);

        case 2: // '\002'
        case 49153: 
        case 49158: 
        case 49163: 
        case 49168: 
            return azB._mth02CA(null, 0, 2);

        case 59: // ';'
            return azB._mth02CA(null, 0, 3);

        case 4: // '\004'
            return azB._mth02CA(null, 2, 1);

        case 5: // '\005'
        case 49154: 
        case 49159: 
        case 49164: 
        case 49169: 
            return azB._mth02CA(null, 2, 2);

        case 58385: 
        case 58387: 
        case 58389: 
        case 58399: 
            return azB._mth02CA(null, 101, 2);

        case 150: 
        case 151: 
        case 152: 
        case 153: 
        case 154: 
            return azB._mth02CA(null, 14, 2);
        }
        throw new TlsFatalAlert((short)80);
    }
}
