// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class jl
{
    static final class if
        implements GenericArrayType, Serializable
    {

        private final Type componentType;

        public final boolean equals(Object obj)
        {
            return (obj instanceof GenericArrayType) && jl.equals(this, (GenericArrayType)obj);
        }

        public final Type getGenericComponentType()
        {
            return componentType;
        }

        public final int hashCode()
        {
            return componentType.hashCode();
        }

        public final String toString()
        {
            return (new StringBuilder()).append(jl.typeToString(componentType)).append("[]").toString();
        }

        public if(Type type)
        {
            componentType = jl._mth02CA(type);
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    static final Type EMPTY_TYPE_ARRAY[] = new Type[0];

    public static boolean equals(Type type, Type type1)
    {
        do
        {
            if (type == type1)
            {
                return true;
            }
            if (type instanceof Class)
            {
                return type.equals(type1);
            }
            if (type instanceof ParameterizedType)
            {
                if (!(type1 instanceof ParameterizedType))
                {
                    return false;
                }
                type = (ParameterizedType)type;
                type1 = (ParameterizedType)type1;
                Type type2 = type.getOwnerType();
                Type type3 = type1.getOwnerType();
                boolean flag;
                if (type2 == type3 || type2 != null && type2.equals(type3))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return flag && type.getRawType().equals(type1.getRawType()) && Arrays.equals(type.getActualTypeArguments(), type1.getActualTypeArguments());
            }
            if (!(type instanceof GenericArrayType))
            {
                break;
            }
            if (!(type1 instanceof GenericArrayType))
            {
                return false;
            }
            type = (GenericArrayType)type;
            type1 = (GenericArrayType)type1;
            type = type.getGenericComponentType();
            type1 = type1.getGenericComponentType();
        } while (true);
        if (type instanceof WildcardType)
        {
            if (!(type1 instanceof WildcardType))
            {
                return false;
            }
            type = (WildcardType)type;
            type1 = (WildcardType)type1;
            return Arrays.equals(type.getUpperBounds(), type1.getUpperBounds()) && Arrays.equals(type.getLowerBounds(), type1.getLowerBounds());
        }
        if (type instanceof TypeVariable)
        {
            if (!(type1 instanceof TypeVariable))
            {
                return false;
            }
            type = (TypeVariable)type;
            type1 = (TypeVariable)type1;
            return type.getGenericDeclaration() == type1.getGenericDeclaration() && type.getName().equals(type1.getName());
        } else
        {
            return false;
        }
    }

    private static Type getGenericSupertype(Type type, Class class1, Class class2)
    {
label0:
        do
        {
            if (class2 == class1)
            {
                return type;
            }
            if (class2.isInterface())
            {
                Class aclass[] = class1.getInterfaces();
                int i = 0;
                int j = aclass.length;
                do
                {
                    if (i >= j)
                    {
                        break;
                    }
                    if (aclass[i] == class2)
                    {
                        return class1.getGenericInterfaces()[i];
                    }
                    if (class2.isAssignableFrom(aclass[i]))
                    {
                        type = class1.getGenericInterfaces()[i];
                        class1 = aclass[i];
                        continue label0;
                    }
                    i++;
                } while (true);
            }
            if (!class1.isInterface())
            {
                type = class1;
                do
                {
                    if (type == java/lang/Object)
                    {
                        break;
                    }
                    class1 = type.getSuperclass();
                    if (class1 == class2)
                    {
                        return type.getGenericSuperclass();
                    }
                    if (class2.isAssignableFrom(class1))
                    {
                        type = type.getGenericSuperclass();
                        continue label0;
                    }
                    type = class1;
                } while (true);
            }
            return class2;
        } while (true);
    }

    public static Class getRawType(Type type)
    {
        do
        {
            if (type instanceof Class)
            {
                return (Class)type;
            }
            if (type instanceof ParameterizedType)
            {
                type = ((ParameterizedType)type).getRawType();
                _cls1D10.aux.checkArgument(type instanceof Class);
                return (Class)type;
            }
            if (type instanceof GenericArrayType)
            {
                return Array.newInstance(getRawType(((GenericArrayType)type).getGenericComponentType()), 0).getClass();
            }
            if (type instanceof TypeVariable)
            {
                return java/lang/Object;
            }
            if (!(type instanceof WildcardType))
            {
                break;
            }
            type = ((WildcardType)type).getUpperBounds()[0];
        } while (true);
        String s;
        if (type == null)
        {
            s = "null";
        } else
        {
            s = type.getClass().getName();
        }
        throw new IllegalArgumentException((new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <")).append(type).append("> is of type ").append(s).toString());
    }

    public static Type resolve(Type type, Class class1, Type type1)
    {
        while (type1 instanceof TypeVariable) 
        {
            TypeVariable typevariable = (TypeVariable)type1;
            type1 = resolveTypeVariable(type, class1, typevariable);
            if (type1 == typevariable)
            {
                return type1;
            }
        }
        if ((type1 instanceof Class) && ((Class)type1).isArray())
        {
            type1 = (Class)type1;
            Class class2 = type1.getComponentType();
            type = resolve(type, class1, ((Type) (class2)));
            if (class2 == type)
            {
                return type1;
            } else
            {
                return new if(type);
            }
        }
        if (type1 instanceof GenericArrayType)
        {
            type1 = (GenericArrayType)type1;
            Type type2 = type1.getGenericComponentType();
            type = resolve(type, class1, type2);
            if (type2 == type)
            {
                return type1;
            } else
            {
                return new if(type);
            }
        }
        if (type1 instanceof ParameterizedType)
        {
            ParameterizedType parameterizedtype = (ParameterizedType)type1;
            type1 = parameterizedtype.getOwnerType();
            Type type3 = resolve(type, class1, type1);
            boolean flag;
            if (type3 != type1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            type1 = parameterizedtype.getActualTypeArguments();
            int i = 0;
            for (int j = type1.length; i < j;)
            {
                Type type4 = resolve(type, class1, type1[i]);
                boolean flag1 = flag;
                Object obj = type1;
                if (type4 != type1[i])
                {
                    flag1 = flag;
                    obj = type1;
                    if (!flag)
                    {
                        obj = (Type[])type1.clone();
                        flag1 = true;
                    }
                    obj[i] = type4;
                }
                i++;
                flag = flag1;
                type1 = ((Type) (obj));
            }

            if (flag)
            {
                return new _cls02CA(type3, parameterizedtype.getRawType(), type1);
            } else
            {
                return parameterizedtype;
            }
        }
        if (type1 instanceof WildcardType)
        {
            type1 = (WildcardType)type1;
            Type atype[] = type1.getLowerBounds();
            Type atype1[] = type1.getUpperBounds();
            if (atype.length == 1)
            {
                type = resolve(type, class1, atype[0]);
                if (type != atype[0])
                {
                    return new _cls02CB(new Type[] {
                        java/lang/Object
                    }, new Type[] {
                        type
                    });
                } else
                {
                    return type1;
                }
            }
            if (atype1.length == 1)
            {
                type = resolve(type, class1, atype1[0]);
                if (type != atype1[0])
                {
                    class1 = EMPTY_TYPE_ARRAY;
                    return new _cls02CB(new Type[] {
                        type
                    }, class1);
                }
            }
            return type1;
        } else
        {
            return type1;
        }
    }

    private static Type resolveTypeVariable(Type type, Class class1, TypeVariable typevariable)
    {
        Object obj = typevariable.getGenericDeclaration();
        if (obj instanceof Class)
        {
            obj = (Class)obj;
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            return typevariable;
        }
        type = getGenericSupertype(type, class1, ((Class) (obj)));
        if (type instanceof ParameterizedType)
        {
            int i = _mth02CA(((Class) (obj)).getTypeParameters(), typevariable);
            return ((ParameterizedType)type).getActualTypeArguments()[i];
        } else
        {
            return typevariable;
        }
    }

    public static String typeToString(Type type)
    {
        if (type instanceof Class)
        {
            return ((Class)type).getName();
        } else
        {
            return type.toString();
        }
    }

    private static int _mth02CA(TypeVariable atypevariable[], TypeVariable typevariable)
    {
        for (int i = 0; i < atypevariable.length; i++)
        {
            if (typevariable.equals(atypevariable[i]))
            {
                return i;
            }
        }

        throw new NoSuchElementException();
    }

    public static Type _mth02CA(Type type)
    {
        if (type instanceof Class)
        {
            type = (Class)type;
            if (type.isArray())
            {
                type = new if(_mth02CA(((Type) (type.getComponentType()))));
            }
            return (Type)type;
        }
        if (type instanceof ParameterizedType)
        {
            type = (ParameterizedType)type;
            return new _cls02CA(type.getOwnerType(), type.getRawType(), type.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType)
        {
            return new if(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof WildcardType)
        {
            type = (WildcardType)type;
            return new _cls02CB(type.getUpperBounds(), type.getLowerBounds());
        } else
        {
            return type;
        }
    }

    public static Type _mth02CA(Type type, Class class1)
    {
        _cls1D10.aux.checkArgument(java/util/Collection.isAssignableFrom(class1));
        class1 = resolve(type, class1, getGenericSupertype(type, class1, java/util/Collection));
        type = class1;
        if (class1 instanceof WildcardType)
        {
            type = ((WildcardType)class1).getUpperBounds()[0];
        }
        if (type instanceof ParameterizedType)
        {
            return ((ParameterizedType)type).getActualTypeArguments()[0];
        } else
        {
            return java/lang/Object;
        }
    }

    public static Type _mth02CB(Type type)
    {
        if (type instanceof GenericArrayType)
        {
            return ((GenericArrayType)type).getGenericComponentType();
        } else
        {
            return ((Class)type).getComponentType();
        }
    }

    public static Type[] _mth02CB(Type type, Class class1)
    {
        if (type == java/util/Properties)
        {
            return (new Type[] {
                java/lang/String, java/lang/String
            });
        }
        _cls1D10.aux.checkArgument(java/util/Map.isAssignableFrom(class1));
        type = resolve(type, class1, getGenericSupertype(type, class1, java/util/Map));
        if (type instanceof ParameterizedType)
        {
            return ((ParameterizedType)type).getActualTypeArguments();
        } else
        {
            return (new Type[] {
                java/lang/Object, java/lang/Object
            });
        }
    }

    static int _mth02CE(Type type)
    {
        if (type != null)
        {
            return type.hashCode();
        } else
        {
            return 0;
        }
    }



/*
    static void access$000(Type type)
    {
        boolean flag;
        if (!(type instanceof Class) || !((Class)type).isPrimitive())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _cls1D10.aux.checkArgument(flag);
        return;
    }

*/
}
