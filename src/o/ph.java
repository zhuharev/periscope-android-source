// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package o:
//            px, pq, pz, pt, 
//            _cls09A3, pn, FEAC, po, 
//            pi, pj, pk, pl

public class ph extends px
{
    final class if
    {

        final ph NX;

        static void _mth02CA(if if1)
        {
            if (ph._mth02CF(if1.NX) != null)
            {
                pt pt1 = new pt(ph._mth02CB(if1.NX));
                Object obj = ph._mth02CF(if1.NX);
                int i;
                if (((pz) (obj)).oW == null)
                {
                    i = 0;
                } else
                {
                    if ((((pz) (obj)).rotation / 90) % 2 != 0)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
                    {
                        i = ((pz) (obj)).oW.getHeight();
                    } else
                    {
                        i = ((pz) (obj)).oW.getWidth();
                    }
                }
                obj = ph._mth02CF(if1.NX);
                int j;
                if (((pz) (obj)).oW == null)
                {
                    j = 0;
                } else
                {
                    if ((((pz) (obj)).rotation / 90) % 2 != 0)
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    if (j != 0)
                    {
                        j = ((pz) (obj)).oW.getWidth();
                    } else
                    {
                        j = ((pz) (obj)).oW.getHeight();
                    }
                }
                obj = new Rect(0, 0, i, j);
                int i1 = (Math.min(i, j) << 2) / 5;
                int j1 = i1;
                int k = j1;
                int l = i1;
                if (ph._mth141D(if1.NX) != 0)
                {
                    k = j1;
                    l = i1;
                    if (ph._mth02BB(if1.NX) != 0)
                    {
                        if (ph._mth141D(if1.NX) > ph._mth02BB(if1.NX))
                        {
                            l = (ph._mth02BB(if1.NX) * j1) / ph._mth141D(if1.NX);
                            k = j1;
                        } else
                        {
                            k = (ph._mth141D(if1.NX) * j1) / ph._mth02BB(if1.NX);
                            l = i1;
                        }
                    }
                }
                i = (i - k) / 2;
                j = (j - l) / 2;
                RectF rectf = new RectF(i, j, i + k, j + l);
                Matrix matrix = ph._mth02CB(if1.NX).FF7F();
                boolean flag;
                if (ph._mth141D(if1.NX) != 0 && ph._mth02BB(if1.NX) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                pt1.Op = new Matrix(matrix);
                pt1.On = rectf;
                pt1.Oq = new RectF(((Rect) (obj)));
                pt1.OA = flag;
                pt1.OB = pt1.On.width() / pt1.On.height();
                pt1.Oo = pt1._mth0128();
                pt1.Or.setARGB(125, 50, 50, 50);
                pt1.Os.setStyle(android.graphics.Paint.Style.STROKE);
                pt1.Os.setAntiAlias(true);
                pt1.outlineWidth = pt1.Ou.getResources().getDisplayMetrics().density * 2.0F;
                pt1.Ot.setColor(pt1.Ox);
                pt1.Ot.setStyle(android.graphics.Paint.Style.FILL);
                pt1.Ot.setAntiAlias(true);
                pt1.OC = pt1.Ou.getResources().getDisplayMetrics().density * 12F;
                pt1.Oy = pt._cls02CA.OI;
                if1 = ph._mth02CB(if1.NX);
                ((pq) (if1)).Oc.add(pt1);
                if1.invalidate();
            }
        }

        private if()
        {
            NX = ph.this;
            super();
        }

        if(byte byte0)
        {
            this();
        }
    }


    private int NM;
    private int NN;
    private int NO;
    private int NP;
    private int NQ;
    private Uri NR;
    private Uri NS;
    boolean NT;
    private pz NU;
    private pq NV;
    private pt NW;
    private final Handler handler = new Handler();
    private int sampleSize;

    public ph()
    {
    }

    private int _mth02BB(Uri uri)
    {
        Uri uri1;
        android.graphics.BitmapFactory.Options options;
        uri1 = null;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        java.io.InputStream inputstream = getContentResolver().openInputStream(uri);
        uri = inputstream;
        uri1 = uri;
        BitmapFactory.decodeStream(inputstream, null, options);
        int i;
        int j;
        if (uri != null)
        {
            try
            {
                uri.close();
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri) { }
        }
        break MISSING_BLOCK_LABEL_67;
        uri;
        if (uri1 != null)
        {
            try
            {
                uri1.close();
            }
            catch (Throwable throwable) { }
        }
        throw uri;
        uri = new int[1];
        GLES10.glGetIntegerv(3379, uri, 0);
        i = uri[0];
        if (i == 0)
        {
            i = 2048;
        } else
        {
            i = Math.min(i, 4096);
        }
        for (j = 1; options.outHeight / j > i || options.outWidth / j > i; j <<= 1) { }
        return j;
    }

    static int _mth02BB(ph ph1)
    {
        return ph1.NN;
    }

    static pt _mth02BC(ph ph1)
    {
        return ph1.NW;
    }

    private Bitmap _mth02CA(Rect rect, int i, int j)
    {
        java.io.InputStream inputstream;
        Bitmap bitmap;
        Object obj;
        java.io.InputStream inputstream2;
        Object obj1;
        java.io.InputStream inputstream3;
        Object obj3;
        Object obj4;
        NV.clear();
        if (NU != null)
        {
            pz pz1 = NU;
            if (pz1.oW != null)
            {
                pz1.oW.recycle();
                pz1.oW = null;
            }
        }
        System.gc();
        inputstream3 = null;
        inputstream = null;
        inputstream2 = null;
        bitmap = null;
        obj3 = null;
        obj4 = null;
        obj = bitmap;
        obj1 = obj3;
        Object obj2 = getContentResolver().openInputStream(NR);
        java.io.InputStream inputstream1;
        inputstream1 = ((java.io.InputStream) (obj2));
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        BitmapRegionDecoder bitmapregiondecoder = BitmapRegionDecoder.newInstance(((java.io.InputStream) (obj2)), false);
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        int k = bitmapregiondecoder.getWidth();
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        int l = bitmapregiondecoder.getHeight();
        obj2 = rect;
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        if (NQ == 0)
        {
            break MISSING_BLOCK_LABEL_483;
        }
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        obj2 = new Matrix();
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        ((Matrix) (obj2)).setRotate(-NQ);
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        RectF rectf = new RectF();
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        ((Matrix) (obj2)).mapRect(rectf, new RectF(rect));
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        float f1;
        float f;
        Throwable throwable;
        IllegalArgumentException illegalargumentexception;
        if (rectf.left < 0.0F)
        {
            f = k;
        } else
        {
            f = 0.0F;
        }
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        if (rectf.top < 0.0F)
        {
            f1 = l;
        } else
        {
            f1 = 0.0F;
        }
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        rectf.offset(f, f1);
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        obj2 = new Rect((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom);
        rect = obj4;
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = obj3;
        inputstream = inputstream1;
        bitmap = bitmapregiondecoder.decodeRegion(((Rect) (obj2)), new android.graphics.BitmapFactory.Options());
        rect = bitmap;
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = bitmap;
        inputstream = inputstream1;
        if (((Rect) (obj2)).width() > i)
        {
            break MISSING_BLOCK_LABEL_590;
        }
        obj3 = bitmap;
        rect = bitmap;
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = bitmap;
        inputstream = inputstream1;
        if (((Rect) (obj2)).height() <= j)
        {
            break MISSING_BLOCK_LABEL_801;
        }
        rect = bitmap;
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = bitmap;
        inputstream = inputstream1;
        obj3 = new Matrix();
        rect = bitmap;
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = bitmap;
        inputstream = inputstream1;
        ((Matrix) (obj3)).postScale((float)i / (float)((Rect) (obj2)).width(), (float)j / (float)((Rect) (obj2)).height());
        rect = bitmap;
        inputstream2 = inputstream1;
        obj = bitmap;
        inputstream3 = inputstream1;
        obj1 = bitmap;
        inputstream = inputstream1;
        obj3 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj3)), true);
        break MISSING_BLOCK_LABEL_801;
        illegalargumentexception;
        inputstream2 = inputstream1;
        obj = rect;
        inputstream3 = inputstream1;
        obj1 = rect;
        inputstream = inputstream1;
        throw new IllegalArgumentException((new StringBuilder("Rectangle ")).append(obj2).append(" is outside of the image (").append(k).append(",").append(l).append(",").append(NQ).append(")").toString(), illegalargumentexception);
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Rect rect)
            {
                return ((Bitmap) (obj3));
            }
            return ((Bitmap) (obj3));
        } else
        {
            return ((Bitmap) (obj3));
        }
        rect;
        inputstream = inputstream2;
        Log.e("android-crop", (new StringBuilder("Error cropping image: ")).append(rect.getMessage()).toString(), rect);
        inputstream = inputstream2;
        finish();
        if (inputstream2 != null)
        {
            try
            {
                inputstream2.close();
            }
            // Misplaced declaration of an exception variable
            catch (Rect rect)
            {
                return ((Bitmap) (obj));
            }
            return ((Bitmap) (obj));
        } else
        {
            return ((Bitmap) (obj));
        }
        rect;
        inputstream = inputstream3;
        Log.e("android-crop", (new StringBuilder("OOM cropping image: ")).append(rect.getMessage()).toString(), rect);
        inputstream = inputstream3;
        setResult(404, (new Intent()).putExtra("error", rect));
        if (inputstream3 != null)
        {
            try
            {
                inputstream3.close();
            }
            // Misplaced declaration of an exception variable
            catch (Rect rect)
            {
                return ((Bitmap) (obj1));
            }
            return ((Bitmap) (obj1));
        } else
        {
            return ((Bitmap) (obj1));
        }
        rect;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable) { }
        }
        throw rect;
    }

    static pt _mth02CA(ph ph1, pt pt1)
    {
        ph1.NW = pt1;
        return pt1;
    }

    static void _mth02CA(ph ph1)
    {
        Object obj;
        int i;
        int j;
label0:
        {
            if (ph1.NW == null || ph1.NT)
            {
                return;
            }
            ph1.NT = true;
            obj = ph1.NW;
            float f = ph1.sampleSize;
            obj = new Rect((int)(((pt) (obj)).On.left * f), (int)(((pt) (obj)).On.top * f), (int)(((pt) (obj)).On.right * f), (int)(((pt) (obj)).On.bottom * f));
            int i1 = ((Rect) (obj)).width();
            int j1 = ((Rect) (obj)).height();
            int k = i1;
            int l = j1;
            i = k;
            j = l;
            if (ph1.NO <= 0)
            {
                break label0;
            }
            i = k;
            j = l;
            if (ph1.NP <= 0)
            {
                break label0;
            }
            if (i1 <= ph1.NO)
            {
                i = k;
                j = l;
                if (j1 <= ph1.NP)
                {
                    break label0;
                }
            }
            f = (float)i1 / (float)j1;
            if ((float)ph1.NO / (float)ph1.NP > f)
            {
                j = ph1.NP;
                i = (int)((float)ph1.NP * f + 0.5F);
            } else
            {
                i = ph1.NO;
                j = (int)((float)ph1.NO / f + 0.5F);
            }
        }
        try
        {
            obj = ph1._mth02CA(((Rect) (obj)), i, j);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ph1.setResult(404, (new Intent()).putExtra("error", ((java.io.Serializable) (obj))));
            ph1.finish();
            return;
        }
        if (obj != null)
        {
            ph1.NV.setImageRotateBitmapResetBase(new pz(((Bitmap) (obj)), ph1.NQ), true);
            ph1.NV._mth02BB(true, true);
            ph1.NV.Oc.clear();
        }
        if (obj != null)
        {
            FEAC._mth02CA(ph1, null, ph1.getResources().getString(_cls09A3.hV), new pn(ph1, ((Bitmap) (obj))), ph1.handler);
            return;
        } else
        {
            ph1.finish();
            return;
        }
    }

    static void _mth02CA(ph ph1, Bitmap bitmap)
    {
        Object obj;
        java.io.OutputStream outputstream;
        if (ph1.NS == null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        outputstream = null;
        obj = null;
        java.io.OutputStream outputstream2 = ph1.getContentResolver().openOutputStream(ph1.NS);
        java.io.OutputStream outputstream1;
        outputstream1 = outputstream2;
        if (outputstream2 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        obj = outputstream1;
        outputstream = outputstream1;
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, outputstream1);
        IOException ioexception;
        if (outputstream1 != null)
        {
            try
            {
                outputstream1.close();
            }
            catch (Throwable throwable) { }
        }
        break MISSING_BLOCK_LABEL_154;
        ioexception;
        outputstream = ((java.io.OutputStream) (obj));
        ph1.setResult(404, (new Intent()).putExtra("error", ioexception));
        outputstream = ((java.io.OutputStream) (obj));
        Log.e("android-crop", (new StringBuilder("Cannot open file: ")).append(ph1.NS).toString(), ioexception);
        if (obj != null)
        {
            try
            {
                ((Closeable) (obj)).close();
            }
            catch (Throwable throwable1) { }
        }
        break MISSING_BLOCK_LABEL_154;
        ph1;
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap) { }
        }
        throw ph1;
        FEAC._mth02CA(FEAC._mth02CA(ph1, ph1.getContentResolver(), ph1.NR), FEAC._mth02CA(ph1, ph1.getContentResolver(), ph1.NS));
        obj = ph1.NS;
        ph1.setResult(-1, (new Intent()).putExtra("output", ((android.os.Parcelable) (obj))));
        ph1.handler.post(new po(ph1, bitmap));
        ph1.finish();
        return;
    }

    static pq _mth02CB(ph ph1)
    {
        return ph1.NV;
    }

    static Handler _mth02CE(ph ph1)
    {
        return ph1.handler;
    }

    static pz _mth02CF(ph ph1)
    {
        return ph1.NU;
    }

    static int _mth141D(ph ph1)
    {
        return ph1.NM;
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        Object obj2;
        java.io.InputStream inputstream;
        android.graphics.BitmapFactory.Options options;
        Object obj3;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(_cls0689.if.hy);
        NV = (pq)findViewById(android.support.v7.widget.RecyclerView._cls02BF.if.fi);
        NV.Oe = this;
        NV.setRecycler(new pi(this));
        findViewById(android.support.v7.widget.RecyclerView._cls02BF.if.fg).setOnClickListener(new pj(this));
        findViewById(android.support.v7.widget.RecyclerView._cls02BF.if.fh).setOnClickListener(new pk(this));
        bundle = getIntent();
        obj = bundle.getExtras();
        if (obj != null)
        {
            NM = ((Bundle) (obj)).getInt("aspect_x");
            NN = ((Bundle) (obj)).getInt("aspect_y");
            NO = ((Bundle) (obj)).getInt("max_x");
            NP = ((Bundle) (obj)).getInt("max_y");
            NS = (Uri)((Bundle) (obj)).getParcelable("output");
        }
        NR = bundle.getData();
        if (NR == null)
        {
            break MISSING_BLOCK_LABEL_486;
        }
        NQ = FEAC._mth02CB(FEAC._mth02CA(this, getContentResolver(), NR));
        options = null;
        obj3 = null;
        inputstream = null;
        obj = inputstream;
        obj2 = options;
        bundle = obj3;
        sampleSize = _mth02BB(NR);
        obj = inputstream;
        obj2 = options;
        bundle = obj3;
        inputstream = getContentResolver().openInputStream(NR);
        obj = inputstream;
        obj2 = inputstream;
        bundle = inputstream;
        options = new android.graphics.BitmapFactory.Options();
        obj = inputstream;
        obj2 = inputstream;
        bundle = inputstream;
        options.inSampleSize = sampleSize;
        obj = inputstream;
        obj2 = inputstream;
        bundle = inputstream;
        NU = new pz(BitmapFactory.decodeStream(inputstream, null, options), NQ);
        Object obj1;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        }
        break MISSING_BLOCK_LABEL_486;
        obj2;
        bundle = ((Bundle) (obj));
        Log.e("android-crop", (new StringBuilder("Error reading image: ")).append(((IOException) (obj2)).getMessage()).toString(), ((Throwable) (obj2)));
        bundle = ((Bundle) (obj));
        setResult(404, (new Intent()).putExtra("error", ((java.io.Serializable) (obj2))));
        if (obj != null)
        {
            try
            {
                ((Closeable) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        }
        break MISSING_BLOCK_LABEL_486;
        obj1;
        bundle = ((Bundle) (obj2));
        Log.e("android-crop", (new StringBuilder("OOM reading image: ")).append(((OutOfMemoryError) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
        bundle = ((Bundle) (obj2));
        setResult(404, (new Intent()).putExtra("error", ((java.io.Serializable) (obj1))));
        if (obj2 != null)
        {
            try
            {
                ((Closeable) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        }
        break MISSING_BLOCK_LABEL_486;
        obj1;
        if (bundle != null)
        {
            try
            {
                bundle.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        }
        throw obj1;
        if (NU == null)
        {
            finish();
            return;
        }
        if (!isFinishing())
        {
            NV.setImageRotateBitmapResetBase(NU, true);
            FEAC._mth02CA(this, null, getResources().getString(_cls09A3.hW), new pl(this), handler);
        }
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (NU != null)
        {
            pz pz1 = NU;
            if (pz1.oW != null)
            {
                pz1.oW.recycle();
                pz1.oW = null;
            }
        }
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public final volatile void _mth02CA(px.if if1)
    {
        super._mth02CA(if1);
    }

    public final volatile void _mth02CB(px.if if1)
    {
        super._mth02CB(if1);
    }
}
