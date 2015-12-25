// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.widget.FrameLayout;

// Referenced classes of package o:
//            amp, amx

public class amw extends amp
    implements android.view.TextureView.SurfaceTextureListener
{
    static final class if extends Thread
    {

        private volatile boolean aUv;
        private final Resources btt;

        public final void run()
        {
            (new amx(this)).setColor(0xff00ff00);
            Bitmap bitmap = BitmapFactory.decodeResource(btt, 0x7f0200e0);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth() - 1, bitmap.getHeight() - 1);
            Paint paint = new Paint();
            paint.setColorFilter(new LightingColorFilter(0xffff0000, 1));
            (new Canvas(bitmap)).drawBitmap(bitmap, 0.0F, 0.0F, paint);
            boolean flag = aUv;
        }
    }


    private TextureView bfO;

    public amw()
    {
    }

    protected final void dr()
    {
        FrameLayout framelayout = new FrameLayout(this);
        bfO = new TextureView(this);
        bfO.setSurfaceTextureListener(this);
        bfO.setOpaque(false);
        framelayout.addView(bfO, new android.widget.FrameLayout.LayoutParams(500, 500, 17));
        setContentView(framelayout);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        throw new NullPointerException();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }
}
