// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Arrays;

// Referenced classes of package o:
//            ats, atn

public final class atf extends ats
{

    private final String accessToken;
    private final String application;
    private final String authToken;
    private final int bDL;
    private final int bDM;
    private final atn bfm;
    private final boolean canShareTwitter;
    private final String channel;
    private final String cipher;
    private final String credential;
    private final String endpoint;
    private final String host;
    private final byte key[];
    private final int participantIndex;
    private final int port;
    private final int privatePort;
    private final String privateProtocol;
    private final String protocol;
    private final int pspVersion[];
    private final String publisher;
    private final boolean shouldLog;
    private final boolean shouldVerifySignature;
    private final String signerKey;
    private final String signerToken;
    private final String streamName;
    private final String subscriber;
    private final String thumbnailUploadUrl;
    private final String uploadUrl;

    public atf(String s, String s1, String s2, String s3, String s4, String s5, int i, 
            String s6, boolean flag, boolean flag1, atn atn, String s7, String s8, int j, 
            String s9, String s10, String s11, String s12, int k, String s13, String s14, 
            boolean flag2, String s15, byte abyte0[], String s16, int l, int i1, int ai[])
    {
        if (s == null)
        {
            throw new NullPointerException("Null subscriber");
        }
        subscriber = s;
        if (s1 == null)
        {
            throw new NullPointerException("Null publisher");
        }
        publisher = s1;
        if (s2 == null)
        {
            throw new NullPointerException("Null authToken");
        }
        authToken = s2;
        if (s3 == null)
        {
            throw new NullPointerException("Null signerKey");
        }
        signerKey = s3;
        if (s4 == null)
        {
            throw new NullPointerException("Null signerToken");
        }
        signerToken = s4;
        cipher = s5;
        participantIndex = i;
        if (s6 == null)
        {
            throw new NullPointerException("Null channel");
        }
        channel = s6;
        shouldLog = flag;
        shouldVerifySignature = flag1;
        if (atn == null)
        {
            throw new NullPointerException("Null broadcast");
        }
        bfm = atn;
        if (s7 == null)
        {
            throw new NullPointerException("Null protocol");
        }
        protocol = s7;
        if (s8 == null)
        {
            throw new NullPointerException("Null host");
        }
        host = s8;
        port = j;
        if (s9 == null)
        {
            throw new NullPointerException("Null application");
        }
        application = s9;
        if (s10 == null)
        {
            throw new NullPointerException("Null streamName");
        }
        streamName = s10;
        if (s11 == null)
        {
            throw new NullPointerException("Null credential");
        } else
        {
            credential = s11;
            privateProtocol = s12;
            privatePort = k;
            uploadUrl = s13;
            thumbnailUploadUrl = s14;
            canShareTwitter = flag2;
            accessToken = s15;
            key = abyte0;
            endpoint = s16;
            bDL = l;
            bDM = i1;
            pspVersion = ai;
            return;
        }
    }

    public final String eF()
    {
        return endpoint;
    }

    public final String eG()
    {
        return accessToken;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof ats)
        {
            ats ats1 = (ats)obj;
            if (subscriber.equals(ats1.ft()) && publisher.equals(ats1.fu()) && authToken.equals(ats1.fv()) && signerKey.equals(ats1.fD()) && signerToken.equals(ats1.fC()) && (cipher != null ? cipher.equals(ats1.fK()) : ats1.fK() == null) && (participantIndex == ats1.fw() && channel.equals(ats1.fx()) && shouldLog == ats1.fE() && shouldVerifySignature == ats1.fF() && bfm.equals(ats1.fo()) && protocol.equals(ats1.fL()) && host.equals(ats1.host()) && port == ats1.fM() && application.equals(ats1.fN()) && streamName.equals(ats1.fO()) && credential.equals(ats1.fP())) && (privateProtocol != null ? privateProtocol.equals(ats1.fQ()) : ats1.fQ() == null) && privatePort == ats1.fR() && (uploadUrl != null ? uploadUrl.equals(ats1.fS()) : ats1.fS() == null) && (thumbnailUploadUrl != null ? thumbnailUploadUrl.equals(ats1.fT()) : ats1.fT() == null) && canShareTwitter == ats1.fU() && (accessToken != null ? accessToken.equals(ats1.eG()) : ats1.eG() == null))
            {
                byte abyte0[] = key;
                if (ats1 instanceof atf)
                {
                    obj = ((atf)ats1).key;
                } else
                {
                    obj = ats1.fV();
                }
                if (Arrays.equals(abyte0, ((byte []) (obj))) && (endpoint != null ? endpoint.equals(ats1.eF()) : ats1.eF() == null) && (bDL == ats1.fH() && bDM == ats1.fI()))
                {
                    int ai[] = pspVersion;
                    if (ats1 instanceof atf)
                    {
                        obj = ((atf)ats1).pspVersion;
                    } else
                    {
                        obj = ats1.fJ();
                    }
                    if (Arrays.equals(ai, ((int []) (obj))))
                    {
                        return true;
                    }
                }
            }
            return false;
        } else
        {
            return false;
        }
    }

    public final String fC()
    {
        return signerToken;
    }

    public final String fD()
    {
        return signerKey;
    }

    public final boolean fE()
    {
        return shouldLog;
    }

    public final boolean fF()
    {
        return shouldVerifySignature;
    }

    public final int fH()
    {
        return bDL;
    }

    public final int fI()
    {
        return bDM;
    }

    public final int[] fJ()
    {
        if (pspVersion == null)
        {
            return null;
        } else
        {
            return (int[])pspVersion.clone();
        }
    }

    public final String fK()
    {
        return cipher;
    }

    public final String fL()
    {
        return protocol;
    }

    public final int fM()
    {
        return port;
    }

    public final String fN()
    {
        return application;
    }

    public final String fO()
    {
        return streamName;
    }

    public final String fP()
    {
        return credential;
    }

    public final String fQ()
    {
        return privateProtocol;
    }

    public final int fR()
    {
        return privatePort;
    }

    public final String fS()
    {
        return uploadUrl;
    }

    public final String fT()
    {
        return thumbnailUploadUrl;
    }

    public final boolean fU()
    {
        return canShareTwitter;
    }

    public final byte[] fV()
    {
        if (key == null)
        {
            return null;
        } else
        {
            return (byte[])key.clone();
        }
    }

    public final atn fo()
    {
        return bfm;
    }

    public final String ft()
    {
        return subscriber;
    }

    public final String fu()
    {
        return publisher;
    }

    public final String fv()
    {
        return authToken;
    }

    public final int fw()
    {
        return participantIndex;
    }

    public final String fx()
    {
        return channel;
    }

    public final int hashCode()
    {
        int k1 = subscriber.hashCode();
        int l1 = publisher.hashCode();
        int i2 = authToken.hashCode();
        int j2 = signerKey.hashCode();
        int k2 = signerToken.hashCode();
        int i;
        if (cipher == null)
        {
            i = 0;
        } else
        {
            i = cipher.hashCode();
        }
        int l2 = participantIndex;
        int i3 = channel.hashCode();
        char c;
        if (shouldLog)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        char c1;
        if (shouldVerifySignature)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        int j3 = bfm.hashCode();
        int k3 = protocol.hashCode();
        int l3 = host.hashCode();
        int i4 = port;
        int j4 = application.hashCode();
        int k4 = streamName.hashCode();
        int l4 = credential.hashCode();
        int j;
        if (privateProtocol == null)
        {
            j = 0;
        } else
        {
            j = privateProtocol.hashCode();
        }
        int i5 = privatePort;
        int k;
        if (uploadUrl == null)
        {
            k = 0;
        } else
        {
            k = uploadUrl.hashCode();
        }
        int l;
        if (thumbnailUploadUrl == null)
        {
            l = 0;
        } else
        {
            l = thumbnailUploadUrl.hashCode();
        }
        char c2;
        if (canShareTwitter)
        {
            c2 = '\u04CF';
        } else
        {
            c2 = '\u04D5';
        }
        int i1;
        if (accessToken == null)
        {
            i1 = 0;
        } else
        {
            i1 = accessToken.hashCode();
        }
        int j5 = Arrays.hashCode(key);
        int j1;
        if (endpoint == null)
        {
            j1 = 0;
        } else
        {
            j1 = endpoint.hashCode();
        }
        return (((((((((((((((((((((((((((k1 ^ 0xf4243) * 0xf4243 ^ l1) * 0xf4243 ^ i2) * 0xf4243 ^ j2) * 0xf4243 ^ k2) * 0xf4243 ^ i) * 0xf4243 ^ l2) * 0xf4243 ^ i3) * 0xf4243 ^ c) * 0xf4243 ^ c1) * 0xf4243 ^ j3) * 0xf4243 ^ k3) * 0xf4243 ^ l3) * 0xf4243 ^ i4) * 0xf4243 ^ j4) * 0xf4243 ^ k4) * 0xf4243 ^ l4) * 0xf4243 ^ j) * 0xf4243 ^ i5) * 0xf4243 ^ k) * 0xf4243 ^ l) * 0xf4243 ^ c2) * 0xf4243 ^ i1) * 0xf4243 ^ j5) * 0xf4243 ^ j1) * 0xf4243 ^ bDL) * 0xf4243 ^ bDM) * 0xf4243 ^ Arrays.hashCode(pspVersion);
    }

    public final String host()
    {
        return host;
    }

    public final String toString()
    {
        return (new StringBuilder("CreatedBroadcast{subscriber=")).append(subscriber).append(", publisher=").append(publisher).append(", authToken=").append(authToken).append(", signerKey=").append(signerKey).append(", signerToken=").append(signerToken).append(", cipher=").append(cipher).append(", participantIndex=").append(participantIndex).append(", channel=").append(channel).append(", shouldLog=").append(shouldLog).append(", shouldVerifySignature=").append(shouldVerifySignature).append(", broadcast=").append(bfm).append(", protocol=").append(protocol).append(", host=").append(host).append(", port=").append(port).append(", application=").append(application).append(", streamName=").append(streamName).append(", credential=").append(credential).append(", privateProtocol=").append(privateProtocol).append(", privatePort=").append(privatePort).append(", uploadUrl=").append(uploadUrl).append(", thumbnailUploadUrl=").append(thumbnailUploadUrl).append(", canShareTwitter=").append(canShareTwitter).append(", accessToken=").append(accessToken).append(", key=").append(Arrays.toString(key)).append(", endpoint=").append(endpoint).append(", pubnubPerms=").append(bDL).append(", chatmanPerms=").append(bDM).append(", pspVersion=").append(Arrays.toString(pspVersion)).append("}").toString();
    }
}
