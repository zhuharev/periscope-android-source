// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.InputStream;

// Referenced classes of package o:
//            FEE9, _cls04CC, _cls1F33, _cls0699, 
//            _cls05D4, _cls148D, _cls30CE, _cls4EA0, 
//            _cls14FF, _cls043E, _cls1502, _cls06BA

public final class _cls1503
    implements FEE9
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static final _cls02CA qp = new _cls02CA();
    private static final if qq = new if();
    private String id;
    private final _cls06BA je;
    private final FEE9 qr;
    private final FEE9 qs;
    private final _cls02CA qt;
    private final if qu;

    public _cls1503(FEE9 fee9, FEE9 fee9_1, _cls06BA _pcls06ba)
    {
        this(fee9, fee9_1, _pcls06ba, qp, qq);
    }

    private _cls1503(FEE9 fee9, FEE9 fee9_1, _cls06BA _pcls06ba, _cls02CA _pcls02ca, if if1)
    {
        qr = fee9;
        qs = fee9_1;
        je = _pcls06ba;
        qt = _pcls02ca;
        qu = if1;
    }

    private _cls1502 _mth02CB(_cls1F33 _pcls1f33, int i, int j)
    {
        _cls04CC _lcls04cc;
        byte abyte0[];
        _lcls04cc = _cls04CC._mth05DB();
        abyte0 = _lcls04cc.getBytes();
        if (_pcls1f33.oI == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        _cls0699 _lcls0699;
        _lcls0699 = new _cls0699(_pcls1f33.oI, abyte0);
        _lcls0699.mark(2048);
        obj1 = (new ImageHeaderParser(_lcls0699)).FB84();
        _lcls0699.reset();
        Object obj = null;
        if (obj1 != com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType.GIF)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        obj = null;
        obj1 = qs._mth02CB(_lcls0699, i, j);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        obj = (_cls148D)((_cls05D4) (obj1)).get();
        if (((_cls148D) (obj)).pG.kC.frameCount > 1)
        {
            obj = new _cls14FF(null, ((_cls05D4) (obj1)));
            break MISSING_BLOCK_LABEL_169;
        }
        obj = new _cls14FF(new _cls043E(((_cls148D) (obj)).pF.pQ, je), null);
        obj1 = obj;
        if (obj != null) goto _L4; else goto _L3
_L3:
        obj1 = _mth02CE(new _cls1F33(_lcls0699, _pcls1f33.oJ), i, j);
          goto _L4
_L2:
        _pcls1f33 = _mth02CE(_pcls1f33, i, j);
_L6:
        _lcls04cc._mth02CF(abyte0);
        break MISSING_BLOCK_LABEL_232;
        _pcls1f33;
        _lcls04cc._mth02CF(abyte0);
        throw _pcls1f33;
        if (_pcls1f33 != null)
        {
            return new _cls1502(_pcls1f33);
        } else
        {
            return null;
        }
_L4:
        _pcls1f33 = ((_cls1F33) (obj1));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private _cls14FF _mth02CE(_cls1F33 _pcls1f33, int i, int j)
    {
        Object obj = null;
        _cls05D4 _lcls05d4 = qr._mth02CB(_pcls1f33, i, j);
        _pcls1f33 = obj;
        if (_lcls05d4 != null)
        {
            _pcls1f33 = new _cls14FF(_lcls05d4, null);
        }
        return _pcls1f33;
    }

    public final String getId()
    {
        if (id == null)
        {
            id = (new StringBuilder()).append(qs.getId()).append(qr.getId()).toString();
        }
        return id;
    }

    public final volatile _cls05D4 _mth02CB(Object obj, int i, int j)
    {
        return _mth02CB((_cls1F33)obj, i, j);
    }

}
