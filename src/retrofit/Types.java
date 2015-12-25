// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

final class Types
{
    static final class GenericArrayTypeImpl
        implements GenericArrayType
    {

        private final Type componentType;

        public final boolean equals(Object obj)
        {
            return (obj instanceof GenericArrayType) && Types.equals(this, (GenericArrayType)obj);
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
            return (new StringBuilder()).append(Types.typeToString(componentType)).append("[]").toString();
        }

        public GenericArrayTypeImpl(Type type)
        {
            componentType = type;
        }
    }

    static final class ParameterizedTypeImpl
        implements ParameterizedType
    {

        private final Type ownerType;
        private final Type rawType;
        private final Type typeArguments[];

        public final boolean equals(Object obj)
        {
            return (obj instanceof ParameterizedType) && Types.equals(this, (ParameterizedType)obj);
        }

        public final Type[] getActualTypeArguments()
        {
            return (Type[])typeArguments.clone();
        }

        public final Type getOwnerType()
        {
            return ownerType;
        }

        public final Type getRawType()
        {
            return rawType;
        }

        public final int hashCode()
        {
            return Arrays.hashCode(typeArguments) ^ rawType.hashCode() ^ Types.hashCodeOrZero(ownerType);
        }

        public final String toString()
        {
            StringBuilder stringbuilder = new StringBuilder((typeArguments.length + 1) * 30);
            stringbuilder.append(Types.typeToString(rawType));
            if (typeArguments.length == 0)
            {
                return stringbuilder.toString();
            }
            stringbuilder.append("<").append(Types.typeToString(typeArguments[0]));
            for (int i = 1; i < typeArguments.length; i++)
            {
                stringbuilder.append(", ").append(Types.typeToString(typeArguments[i]));
            }

            return stringbuilder.append(">").toString();
        }

        public transient ParameterizedTypeImpl(Type type, Type type1, Type atype[])
        {
            if (type1 instanceof Class)
            {
                boolean flag;
                if (type == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                boolean flag1;
                if (((Class)type1).getEnclosingClass() == null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag != flag1)
                {
                    throw new IllegalArgumentException();
                }
            }
            ownerType = type;
            rawType = type1;
            typeArguments = (Type[])atype.clone();
            type = typeArguments;
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                type1 = type[i];
                if (type1 == null)
                {
                    throw new NullPointerException();
                }
                Types.checkNotPrimitive(type1);
            }

        }
    }

    static final class WildcardTypeImpl
        implements WildcardType
    {

        private final Type lowerBound;
        private final Type upperBound;

        public final boolean equals(Object obj)
        {
            return (obj instanceof WildcardType) && Types.equals(this, (WildcardType)obj);
        }

        public final Type[] getLowerBounds()
        {
            if (lowerBound != null)
            {
                return (new Type[] {
                    lowerBound
                });
            } else
            {
                return Types.EMPTY_TYPE_ARRAY;
            }
        }

        public final Type[] getUpperBounds()
        {
            return (new Type[] {
                upperBound
            });
        }

        public final int hashCode()
        {
            int i;
            if (lowerBound != null)
            {
                i = lowerBound.hashCode() + 31;
            } else
            {
                i = 1;
            }
            return i ^ upperBound.hashCode() + 31;
        }

        public final String toString()
        {
            if (lowerBound != null)
            {
                return (new StringBuilder("? super ")).append(Types.typeToString(lowerBound)).toString();
            }
            if (upperBound == java/lang/Object)
            {
                return "?";
            } else
            {
                return (new StringBuilder("? extends ")).append(Types.typeToString(upperBound)).toString();
            }
        }

        public WildcardTypeImpl(Type atype[], Type atype1[])
        {
            if (atype1.length > 1)
            {
                throw new IllegalArgumentException();
            }
            if (atype.length != 1)
            {
                throw new IllegalArgumentException();
            }
            if (atype1.length == 1)
            {
                if (atype1[0] == null)
                {
                    throw new NullPointerException();
                }
                Types.checkNotPrimitive(atype1[0]);
                if (atype[0] != java/lang/Object)
                {
                    throw new IllegalArgumentException();
                } else
                {
                    lowerBound = atype1[0];
                    upperBound = java/lang/Object;
                    return;
                }
            }
            if (atype[0] == null)
            {
                throw new NullPointerException();
            } else
            {
                Types.checkNotPrimitive(atype[0]);
                lowerBound = null;
                upperBound = atype[0];
                return;
            }
        }
    }


    private static final Type EMPTY_TYPE_ARRAY[] = new Type[0];

    private Types()
    {
    }

    private static void checkNotPrimitive(Type type)
    {
        if ((type instanceof Class) && ((Class)type).isPrimitive())
        {
            throw new IllegalArgumentException();
        } else
        {
            return;
        }
    }

    private static Class declaringClassOf(TypeVariable typevariable)
    {
        typevariable = typevariable.getGenericDeclaration();
        if (typevariable instanceof Class)
        {
            return (Class)typevariable;
        } else
        {
            return null;
        }
    }

    private static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

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
                return equal(type.getOwnerType(), type1.getOwnerType()) && type.getRawType().equals(type1.getRawType()) && Arrays.equals(type.getActualTypeArguments(), type1.getActualTypeArguments());
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

    static Type getGenericSupertype(Type type, Class class1, Class class2)
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
                if (!(type instanceof Class))
                {
                    throw new IllegalArgumentException();
                } else
                {
                    return (Class)type;
                }
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

    public static Type getSupertype(Type type, Class class1, Class class2)
    {
        if (!class2.isAssignableFrom(class1))
        {
            throw new IllegalArgumentException();
        } else
        {
            return resolve(type, class1, getGenericSupertype(type, class1, class2));
        }
    }

    private static int hashCodeOrZero(Object obj)
    {
        if (obj != null)
        {
            return obj.hashCode();
        } else
        {
            return 0;
        }
    }

    private static int indexOf(Object aobj[], Object obj)
    {
        for (int i = 0; i < aobj.length; i++)
        {
            if (obj.equals(aobj[i]))
            {
                return i;
            }
        }

        throw new NoSuchElementException();
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
                return new GenericArrayTypeImpl(type);
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
                return new GenericArrayTypeImpl(type);
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
                return new ParameterizedTypeImpl(type3, parameterizedtype.getRawType(), type1);
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
                    return new WildcardTypeImpl(new Type[] {
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
                    return new WildcardTypeImpl(new Type[] {
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
        Class class2 = declaringClassOf(typevariable);
        if (class2 == null)
        {
            return typevariable;
        }
        type = getGenericSupertype(type, class1, class2);
        if (type instanceof ParameterizedType)
        {
            int i = indexOf(class2.getTypeParameters(), typevariable);
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




}
