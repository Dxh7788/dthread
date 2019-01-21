package com.dthread.unsafe;

import com.dthread.model.User;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author dongxiaohong
 * @date 2019/1/17 15:01
 */
public class TestUnSafe {

    private static int byteArrayBaseOffset;

    private static long nameOffset;
    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);
        System.out.println(unsafe);

        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));
        byteArrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        System.out.println("偏移量:"+byteArrayBaseOffset);


        unsafe.putByte(data, byteArrayBaseOffset, (byte)1);
        unsafe.putByte(data, byteArrayBaseOffset+5, (byte)5);
        System.out.println(Arrays.toString(data));

        Class clz = User.class;
        nameOffset = unsafe.objectFieldOffset(clz.getDeclaredField("name"));
        User user = new User();
        /**
         * 相当于 user中有一个set方法,比如此处为User中的setName
         * user.setName("dxh");
         * */
        unsafe.putObject(user, nameOffset, "dxh");
        System.out.println(user.getName());
        System.out.println(unsafe.getObject(user,nameOffset));
    }
}
