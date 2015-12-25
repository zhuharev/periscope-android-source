// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, TlsFatalAlert, SupplementalDataEntry, TlsKeyExchange, 
//            TlsContext, SecurityParameters, TlsSession, TlsHandshakeHash, 
//            TlsExtensionsUtils, Certificate, AbstractTlsContext, ProtocolVersion, 
//            TlsSessionImpl

public abstract class TlsProtocol
{
    class HandshakeMessage extends ByteArrayOutputStream
    {

        private TlsProtocol aCr;

        final void _mth0E42()
        {
            int i = count - 4;
            TlsUtils._mth05E0(i);
            TlsUtils._mth02BD(i, buf, 1);
            aCr._mth1D54(buf, 0, count);
            buf = null;
        }

        HandshakeMessage(short word0)
        {
            this(word0, 60);
        }

        HandshakeMessage(short word0, int i)
        {
            aCr = TlsProtocol.this;
            super(i + 4);
            TlsUtils._mth02CA(word0, this);
            count = count + 3;
        }
    }


    protected static final Integer aCh = Integers.valueOf(65281);
    protected static final Integer aCi = Integers.valueOf(35);
    protected int aAc[];
    protected short aAd[];
    protected Hashtable aAe;
    protected boolean aAg;
    protected boolean aAi;
    protected boolean aAj;
    protected Hashtable aAt;
    protected Certificate aBo;
    private volatile boolean aCj;
    volatile boolean aCk;
    private volatile boolean aCl;
    private byte aCm[];
    protected TlsSessionImpl aCn;
    protected short aCo;
    protected boolean aCp;
    private boolean aCq;
    private volatile boolean closed;

    protected static Vector _mth02BE(ByteArrayInputStream bytearrayinputstream)
    {
        byte abyte0[] = TlsUtils._mth02C9(bytearrayinputstream);
        if (bytearrayinputstream.available() > 0)
        {
            throw new TlsFatalAlert((short)50);
        }
        bytearrayinputstream = new ByteArrayInputStream(abyte0);
        Vector vector = new Vector();
        for (; bytearrayinputstream.available() > 0; vector.addElement(new SupplementalDataEntry(TlsUtils._mth037A(bytearrayinputstream), TlsUtils._mth02C8(bytearrayinputstream)))) { }
        return vector;
    }

    protected static int _mth02CA(AbstractTlsContext abstracttlscontext, int i)
    {
        boolean flag = TlsUtils._mth02CF(abstracttlscontext);
        switch (i)
        {
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        case 103: // 'g'
        case 104: // 'h'
        case 105: // 'i'
        case 106: // 'j'
        case 107: // 'k'
        case 156: 
        case 158: 
        case 160: 
        case 162: 
        case 164: 
        case 168: 
        case 170: 
        case 172: 
        case 186: 
        case 187: 
        case 188: 
        case 189: 
        case 190: 
        case 191: 
        case 192: 
        case 193: 
        case 194: 
        case 195: 
        case 196: 
        case 197: 
        case 49187: 
        case 49189: 
        case 49191: 
        case 49193: 
        case 49195: 
        case 49197: 
        case 49199: 
        case 49201: 
        case 49266: 
        case 49268: 
        case 49270: 
        case 49272: 
        case 49274: 
        case 49276: 
        case 49278: 
        case 49280: 
        case 49282: 
        case 49284: 
        case 49286: 
        case 49288: 
        case 49290: 
        case 49292: 
        case 49294: 
        case 49296: 
        case 49298: 
        case 49308: 
        case 49309: 
        case 49310: 
        case 49311: 
        case 49312: 
        case 49313: 
        case 49314: 
        case 49315: 
        case 49316: 
        case 49317: 
        case 49318: 
        case 49319: 
        case 49320: 
        case 49321: 
        case 49322: 
        case 49323: 
        case 52243: 
        case 52244: 
        case 52245: 
            if (flag)
            {
                return 1;
            } else
            {
                throw new TlsFatalAlert((short)47);
            }

        case 157: 
        case 159: 
        case 161: 
        case 163: 
        case 165: 
        case 169: 
        case 171: 
        case 173: 
        case 49188: 
        case 49190: 
        case 49192: 
        case 49194: 
        case 49196: 
        case 49198: 
        case 49200: 
        case 49202: 
        case 49267: 
        case 49269: 
        case 49271: 
        case 49273: 
        case 49275: 
        case 49277: 
        case 49279: 
        case 49281: 
        case 49283: 
        case 49285: 
        case 49287: 
        case 49289: 
        case 49291: 
        case 49293: 
        case 49295: 
        case 49297: 
        case 49299: 
            if (flag)
            {
                return 2;
            } else
            {
                throw new TlsFatalAlert((short)47);
            }

        case 175: 
        case 177: 
        case 179: 
        case 181: 
        case 183: 
        case 185: 
        case 49208: 
        case 49211: 
        case 49301: 
        case 49303: 
        case 49305: 
        case 49307: 
            return !flag ? 0 : 2;
        }
        return !flag ? 0 : 1;
    }

    protected static void _mth02CA(AbstractTlsContext abstracttlscontext, TlsKeyExchange tlskeyexchange)
    {
        tlskeyexchange = tlskeyexchange._mth0E04();
        abstracttlscontext._mth03DC().aBi = TlsUtils._mth02CA(abstracttlscontext, tlskeyexchange);
        if (tlskeyexchange != null)
        {
            Arrays.fill(tlskeyexchange, (byte)0);
            return;
        } else
        {
            return;
        }
        abstracttlscontext;
        if (tlskeyexchange != null)
        {
            Arrays.fill(tlskeyexchange, (byte)0);
        }
        throw abstracttlscontext;
    }

    protected static void _mth02CA(HandshakeMessage handshakemessage, Hashtable hashtable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[];
        for (Enumeration enumeration = hashtable.keys(); enumeration.hasMoreElements(); TlsUtils._mth02CE(abyte0, bytearrayoutputstream))
        {
            Integer integer = (Integer)enumeration.nextElement();
            int i = integer.intValue();
            abyte0 = (byte[])hashtable.get(integer);
            TlsUtils._mth05DF(i);
            TlsUtils._mth02CF(i, bytearrayoutputstream);
        }

        TlsUtils._mth02CE(bytearrayoutputstream.toByteArray(), handshakemessage);
    }

    private void _mth02CA(short word0, short word1, String s, Exception exception)
    {
        if (!closed)
        {
            closed = true;
            if (word0 == 2)
            {
                if (aCn != null)
                {
                    aCn.invalidate();
                    aCn = null;
                }
                aCj = true;
            }
            _mth02CA((short)21, new byte[] {
                (byte)word0, (byte)word1
            }, 0, 2);
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            if (word0 != 2)
            {
                return;
            }
        }
        throw new IOException("Internal TLS error, this could be an attack");
    }

    private void _mth02CA(short word0, byte abyte0[], int i, int j)
    {
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            if (!closed)
            {
                _mth02CA((short)2, ((TlsFatalAlert) (abyte0)).aBX, "Failed to write record", ((Exception) (abyte0)));
            }
            throw abyte0;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            if (!closed)
            {
                _mth02CA((short)2, (short)80, "Failed to write record", ((Exception) (abyte0)));
            }
            throw abyte0;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[]) { }
        if (!closed)
        {
            _mth02CA((short)2, (short)80, "Failed to write record", ((Exception) (abyte0)));
        }
        throw abyte0;
    }

    protected static byte[] _mth02CA(AbstractTlsContext abstracttlscontext, TlsHandshakeHash tlshandshakehash, byte abyte0[])
    {
        tlshandshakehash = tlshandshakehash._mth067A();
        if (abyte0 != null && TlsUtils._mth02CB(abstracttlscontext))
        {
            tlshandshakehash.update(abyte0, 0, abyte0.length);
        }
        abstracttlscontext = new byte[tlshandshakehash._mth14AF()];
        tlshandshakehash.doFinal(abstracttlscontext, 0);
        return abstracttlscontext;
    }

    protected static void _mth037A(ByteArrayInputStream bytearrayinputstream)
    {
        if (bytearrayinputstream.available() > 0)
        {
            throw new TlsFatalAlert((short)50);
        } else
        {
            return;
        }
    }

    private byte[] _mth13A5(boolean flag)
    {
        _mth09B9();
        if (flag)
        {
            _mth09B9();
            throw new NullPointerException();
        } else
        {
            _mth09B9();
            throw new NullPointerException();
        }
    }

    private void _mth1424(boolean flag)
    {
        if (!closed)
        {
            if (flag)
            {
                flag = aCk;
                _mth02CA((short)90, "User canceled handshake");
            }
            _mth02CA((short)1, (short)0, "Connection closed", ((Exception) (null)));
        }
    }

    protected static Hashtable _mth1FBE(ByteArrayInputStream bytearrayinputstream)
    {
        if (bytearrayinputstream.available() <= 0)
        {
            return null;
        }
        byte abyte0[] = TlsUtils._mth02C8(bytearrayinputstream);
        if (bytearrayinputstream.available() > 0)
        {
            throw new TlsFatalAlert((short)50);
        }
        bytearrayinputstream = new ByteArrayInputStream(abyte0);
        Hashtable hashtable = new Hashtable();
        while (bytearrayinputstream.available() > 0) 
        {
            if (hashtable.put(Integers.valueOf(TlsUtils._mth037A(bytearrayinputstream)), TlsUtils._mth02C8(bytearrayinputstream)) != null)
            {
                throw new TlsFatalAlert((short)47);
            }
        }
        return hashtable;
    }

    public final void close()
    {
        _mth1424(true);
    }

    protected final void flush()
    {
        throw new NullPointerException();
    }

    protected void _mth02BB(short word0)
    {
    }

    protected final void _mth02BD(ByteArrayInputStream bytearrayinputstream)
    {
        byte abyte0[] = TlsUtils._mth02CF(aCm.length, bytearrayinputstream);
        if (bytearrayinputstream.available() > 0)
        {
            throw new TlsFatalAlert((short)50);
        }
        if (!Arrays._mth1428(aCm, abyte0))
        {
            throw new TlsFatalAlert((short)51);
        } else
        {
            return;
        }
    }

    protected final short _mth02CA(Hashtable hashtable, Hashtable hashtable1, short word0)
    {
        short word1 = TlsExtensionsUtils._mth02C8(hashtable1);
        if (word1 >= 0 && !aCp && word1 != TlsExtensionsUtils._mth02C8(hashtable))
        {
            throw new TlsFatalAlert(word0);
        } else
        {
            return word1;
        }
    }

    protected final void _mth02CA(short word0, String s)
    {
        _mth02CA((short)21, new byte[] {
            1, (byte)word0
        }, 0, 2);
    }

    protected abstract void _mth02CA(short word0, byte abyte0[]);

    protected final void _mth02CE(Vector vector)
    {
        HandshakeMessage handshakemessage = new HandshakeMessage((short)23);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        for (int i = 0; i < vector.size(); i++)
        {
            SupplementalDataEntry supplementaldataentry = (SupplementalDataEntry)vector.elementAt(i);
            int j = supplementaldataentry.getDataType();
            TlsUtils._mth05DF(j);
            TlsUtils._mth02CF(j, bytearrayoutputstream);
            TlsUtils._mth02CE(supplementaldataentry.getData(), bytearrayoutputstream);
        }

        TlsUtils._mth02CF(bytearrayoutputstream.toByteArray(), handshakemessage);
        handshakemessage._mth0E42();
    }

    protected final void _mth02CE(Certificate certificate)
    {
        Certificate certificate1 = certificate;
        if (certificate == null)
        {
            certificate1 = Certificate.azN;
        }
        if (certificate1.getLength() == 0 && !_mth09B9()._mth09B0())
        {
            certificate = _mth09B9().azG;
            boolean flag;
            if (certificate == ProtocolVersion.aAF)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                _mth02CA((short)41, (new StringBuilder()).append(certificate.toString()).append(" client didn't provide credentials").toString());
                return;
            }
        }
        certificate = new HandshakeMessage((short)11);
        certificate1._mth02CA(certificate);
        certificate._mth0E42();
    }

    void _mth0674(byte abyte0[], int i, int j)
    {
        if (j < 0)
        {
            if (TlsUtils._mth05D9(abyte0, i + 0) != 1)
            {
                throw new TlsFatalAlert((short)50);
            }
            if (!aCq)
            {
                throw new NullPointerException();
            } else
            {
                throw new TlsFatalAlert((short)10);
            }
        } else
        {
            return;
        }
    }

    protected abstract AbstractTlsContext _mth09B9();

    void _mth0E1B()
    {
        throw new NullPointerException();
    }

    void _mth0E1C()
    {
        throw new NullPointerException();
    }

    protected final void _mth0E20()
    {
        if (aCn != null)
        {
            aCn.invalidate();
            aCn = null;
        }
    }

    protected final void _mth0E25()
    {
        _mth02CA((short)20, new byte[] {
            1
        }, 0, 1);
        throw new NullPointerException();
    }

    protected final void _mth0E2B()
    {
        byte abyte0[] = _mth13A5(_mth09B9()._mth09B0());
        HandshakeMessage handshakemessage = new HandshakeMessage((short)20, abyte0.length);
        handshakemessage.write(abyte0);
        handshakemessage._mth0E42();
    }

    protected final int _mth1D35(byte abyte0[], int i, int j)
    {
        if (j <= 0)
        {
            return 0;
        } else
        {
            throw new NullPointerException();
        }
    }

    protected final void _mth1D4E(byte abyte0[], int i, int j)
    {
        if (closed)
        {
            if (aCj)
            {
                throw new IOException("Internal TLS error, this could be an attack");
            } else
            {
                throw new IOException("Sorry, connection has been closed, you cannot write more data");
            }
        }
        while (j > 0) 
        {
            boolean flag = aCl;
            if (j > 0)
            {
                throw new NullPointerException();
            }
        }
    }

    protected final void _mth1D54(byte abyte0[], int i, int j)
    {
        if (j > 0)
        {
            throw new NullPointerException();
        } else
        {
            return;
        }
    }

}
