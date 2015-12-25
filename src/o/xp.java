// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import java.io.IOException;

// Referenced classes of package o:
//            xm, aax, _cls0675

final class xp
    implements aar._cls02CB
{

    private xm aTI;

    xp(xm xm1)
    {
        aTI = xm1;
        super();
    }

    public final void FB8C()
    {
        aax aax1;
        IllegalStateException illegalstateexception;
        try
        {
            xm._mth02CF(aTI);
            aax1 = xm._mth141D(aTI);
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        if (aax1 == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        xm._mth141D(aTI).U();
        break MISSING_BLOCK_LABEL_37;
        illegalstateexception;
        illegalstateexception.printStackTrace();
        xm._mth02CA(aTI, new aax());
        xm._mth141D(aTI).bbE.setOnFrameAvailableListener(aTI);
        xm._mth02BB(aTI).setPreviewTexture(xm._mth141D(aTI).bbE);
        aTI.FB89();
        return;
    }

    public final void FB90()
    {
        _cls0675._mth02CB(new RuntimeException("Failed to reset camera, couldn't acquire video context"));
    }
}
