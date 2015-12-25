// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.RandomGenerator;

// Referenced classes of package org.spongycastle.crypto.tls:
//            SecurityParameters, ProtocolVersion

public interface TlsContext
{

    public abstract RandomGenerator _mth03CB();

    public abstract SecureRandom _mth03D2();

    public abstract SecurityParameters _mth03DC();

    public abstract ProtocolVersion _mth043A();

    public abstract ProtocolVersion _mth0455();

    public abstract boolean _mth09B0();
}
