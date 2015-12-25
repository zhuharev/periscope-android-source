// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.util.Hashtable;

// Referenced classes of package org.spongycastle.crypto.tls:
//            DTLSProtocol, TlsKeyExchange, CertificateRequest, TlsServer, 
//            TlsServerContextImpl, TlsCredentials, Certificate

public class DTLSServerProtocol extends DTLSProtocol
{
    public static class ServerHandshakeState
    {

        private boolean aAg;
        private short aAh;
        private boolean aAi;
        private boolean aAj;
        private TlsKeyExchange aAk;
        private CertificateRequest aAn;
        private TlsServer aAr;
        private TlsServerContextImpl aAs;
        private Hashtable aAt;
        private TlsCredentials aAu;
        private short aAv;
        private Certificate aAw;
        private int azD;
        private short azE;

        protected ServerHandshakeState()
        {
            aAr = null;
            aAs = null;
            azD = -1;
            azE = -1;
            aAg = false;
            aAh = -1;
            aAi = false;
            aAj = false;
            aAt = null;
            aAk = null;
            aAu = null;
            aAn = null;
            aAv = -1;
            aAw = null;
        }
    }

}
