// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit.converter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import o.ig;
import o.is;
import o.iu;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

// Referenced classes of package retrofit.converter:
//            Converter, ConversionException

public class GsonConverter
    implements Converter
{
    static class JsonTypedOutput
        implements TypedOutput
    {

        private final byte jsonBytes[];
        private final String mimeType;

        public String fileName()
        {
            return null;
        }

        public long length()
        {
            return (long)jsonBytes.length;
        }

        public String mimeType()
        {
            return mimeType;
        }

        public void writeTo(OutputStream outputstream)
        {
            outputstream.write(jsonBytes);
        }

        JsonTypedOutput(byte abyte0[], String s)
        {
            jsonBytes = abyte0;
            mimeType = (new StringBuilder("application/json; charset=")).append(s).toString();
        }
    }


    private String charset;
    private final ig gson;

    public GsonConverter(ig ig1)
    {
        this(ig1, "UTF-8");
    }

    public GsonConverter(ig ig1, String s)
    {
        gson = ig1;
        charset = s;
    }

    public Object fromBody(TypedInput typedinput, Type type)
    {
        Object obj;
        TypedInput typedinput1;
        TypedInput typedinput2;
        String s;
        obj = charset;
        s = ((String) (obj));
        if (typedinput.mimeType() != null)
        {
            s = MimeUtil.parseCharset(typedinput.mimeType(), ((String) (obj)));
        }
        typedinput2 = null;
        obj = null;
        typedinput1 = null;
        typedinput = new InputStreamReader(typedinput.in(), s);
        typedinput1 = typedinput;
        typedinput2 = typedinput;
        obj = typedinput;
        type = ((Type) (gson._mth02CA(typedinput, type)));
        try
        {
            typedinput.close();
        }
        // Misplaced declaration of an exception variable
        catch (TypedInput typedinput)
        {
            return type;
        }
        return type;
        typedinput;
        obj = typedinput1;
        throw new ConversionException(typedinput);
        typedinput;
        obj = typedinput2;
        throw new ConversionException(typedinput);
        typedinput;
        if (obj != null)
        {
            try
            {
                ((InputStreamReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Type type) { }
        }
        throw typedinput;
    }

    public TypedOutput toBody(Object obj)
    {
        ig ig1;
        try
        {
            ig1 = gson;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AssertionError(obj);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        obj = ig1._mth02CA(is.GB);
        break MISSING_BLOCK_LABEL_30;
        obj = ig1._mth02CA(obj, obj.getClass());
        obj = new JsonTypedOutput(((String) (obj)).getBytes(charset), charset);
        return ((TypedOutput) (obj));
    }
}
