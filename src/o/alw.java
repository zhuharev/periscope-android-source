// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import tv.periscope.android.api.UploadProfileImageResponse;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            ada, _cls0675, apu, aoe, 
//            zu, aui, aos, FF6A

public class alw extends ada
    implements android.view.SurfaceHolder.Callback, android.view.View.OnClickListener, android.hardware.Camera.PictureCallback
{

    private Camera aTc;
    private android.hardware.Camera.CameraInfo aTd;
    private apu bss;
    private View bst;

    public alw()
    {
        aTd = new android.hardware.Camera.CameraInfo();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558731: 
            if (aTc == null)
            {
                _cls0675._mth02CB(new IllegalStateException("Take photo button should not be clickable"));
                return;
            } else
            {
                aTc.takePicture(null, null, this);
                return;
            }

        case 2131558650: 
            onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        int i;
        super.onCreate(bundle);
        setContentView(0x7f03006f);
        bundle = (SurfaceView)findViewById(0x7f0d0149);
        bss = (apu)findViewById(0x7f0d014a);
        bundle.getHolder().addCallback(this);
        bst = findViewById(0x7f0d014b);
        bst.setOnClickListener(this);
        findViewById(0x7f0d00fa).setOnClickListener(this);
        Object obj;
        int j;
        try
        {
            aTc = aoe._mth02CA(1, aTd);
            obj = ((WindowManager)getSystemService("window")).getDefaultDisplay();
            bundle = new Point();
            ((Display) (obj)).getSize(bundle);
            obj = aTc.getParameters();
            bundle = Size._mth05D5(((Point) (bundle)).x, ((Point) (bundle)).y);
            i = aTd.orientation;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bst.setVisibility(4);
            Toast.makeText(this, 0x7f060075, 0).show();
            return;
        }
        if (i != 90 && i != 270)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        bundle = Size._mth05D5(((Size) (bundle))._fld0575, ((Size) (bundle)).bac);
        bundle = aoe._mth02CA(bundle, ((android.hardware.Camera.Parameters) (obj)).getSupportedPreviewSizes());
        ((android.hardware.Camera.Parameters) (obj)).setPreviewSize(((Size) (bundle)).bac, ((Size) (bundle))._fld0575);
        j = getWindowManager().getDefaultDisplay().getRotation();
        i = 0;
        j;
        JVM INSTR tableswitch 0 3: default 348
    //                   0 351
    //                   1 356
    //                   2 362
    //                   3 369;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (aTd.facing != 1) goto _L7; else goto _L6
_L6:
        i = (360 - (aTd.orientation + i) % 360) % 360;
          goto _L8
_L7:
        i = ((aTd.orientation - i) + 360) % 360;
_L8:
        aTc.setDisplayOrientation(i);
        aTc.setParameters(((android.hardware.Camera.Parameters) (obj)));
        aTc.startPreview();
        bst.setVisibility(0);
        return;
_L2:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 90;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 180;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 270;
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void onEventMainThread(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aYj.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            zu1 = (UploadProfileImageResponse)zu1.data;
            break;
        }
        if (zu1 != null && aui._mth02BF(((UploadProfileImageResponse) (zu1)).filename))
        {
            zu1 = new File(((UploadProfileImageResponse) (zu1)).filename);
            if (zu1.exists())
            {
                zu1.delete();
            }
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (aTc != null)
        {
            aTc.stopPreview();
            aTc.release();
            aTc = null;
        }
    }

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        Bitmap bitmap;
        File file;
        byte abyte1[];
        camera = bss;
        Object obj = new RectF(0.0F, ((apu) (camera)).bzl - ((apu) (camera)).bzk, ((apu) (camera)).bzj, ((apu) (camera)).bzl + ((apu) (camera)).bzk);
        camera = aos._mth02B2(this);
        RectF rectf = new RectF(0.0F, 0.0F, ((Point) (camera)).x, ((Point) (camera)).y);
        camera = new Matrix();
        if (aTd.orientation != 0)
        {
            camera.postRotate(aTd.orientation);
        }
        abyte0 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        if (aTd.orientation != 0)
        {
            camera = Bitmap.createBitmap(abyte0, 0, 0, abyte0.getWidth(), abyte0.getHeight(), camera, true);
            abyte0.recycle();
            abyte0 = camera;
        }
        float f;
        if (rectf.width() > (float)abyte0.getWidth())
        {
            f = (float)abyte0.getWidth() / rectf.width();
        } else
        {
            f = 1.0F;
        }
        float f1;
        if (rectf.height() > (float)abyte0.getHeight())
        {
            f1 = (float)abyte0.getHeight() / rectf.height();
        } else
        {
            f1 = 1.0F;
        }
        f = Math.min(f, f1);
        camera = new RectF(((RectF) (obj)));
        obj = new Matrix();
        ((Matrix) (obj)).postScale(f, f);
        ((Matrix) (obj)).mapRect(camera);
        bitmap = Bitmap.createBitmap(abyte0, (int)((RectF) (camera)).left, (int)((RectF) (camera)).top, (int)camera.width(), (int)camera.height());
        abyte0 = Bitmap.createScaledBitmap(bitmap, 1024, 1024, false);
        bitmap.recycle();
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
        abyte1 = bytearrayoutputstream.toByteArray();
        try
        {
            file = File.createTempFile("profile-image", ".jpg", getCacheDir());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            FF6A._mth02CA("CaptureProfileImage", "Unable to create temp file", abyte0);
            Toast.makeText(this, 0x7f060077, 0).show();
            return;
        }
        camera = null;
        abyte0 = null;
        Object obj1 = new FileOutputStream(file);
        FileOutputStream fileoutputstream;
        fileoutputstream = ((FileOutputStream) (obj1));
        abyte0 = fileoutputstream;
        camera = fileoutputstream;
        ((FileOutputStream) (obj1)).write(abyte1);
        abyte0 = fileoutputstream;
        camera = fileoutputstream;
        obj1 = new Intent();
        abyte0 = fileoutputstream;
        camera = fileoutputstream;
        ((Intent) (obj1)).putExtra("e_filename", file.getAbsolutePath());
        abyte0 = fileoutputstream;
        camera = fileoutputstream;
        setResult(-1, ((Intent) (obj1)));
        bitmap.recycle();
        IOException ioexception;
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[]) { }
        }
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[]) { }
        }
        break MISSING_BLOCK_LABEL_549;
        ioexception;
        camera = abyte0;
        FF6A._mth02CA("CaptureProfileImage", "Unable to write to disk.", ioexception);
        bitmap.recycle();
        if (abyte0 != null)
        {
            try
            {
                abyte0.close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[]) { }
        }
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[]) { }
        }
        break MISSING_BLOCK_LABEL_549;
        abyte0;
        bitmap.recycle();
        if (camera != null)
        {
            try
            {
                camera.close();
            }
            // Misplaced declaration of an exception variable
            catch (Camera camera) { }
        }
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Camera camera) { }
        }
        throw abyte0;
        finish();
        return;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        if (aTc != null)
        {
            try
            {
                aTc.setPreviewDisplay(surfaceholder);
                aTc.startPreview();
                bst.setVisibility(0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SurfaceHolder surfaceholder)
            {
                bst.setVisibility(4);
            }
            Toast.makeText(this, 0x7f060075, 0).show();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }
}
