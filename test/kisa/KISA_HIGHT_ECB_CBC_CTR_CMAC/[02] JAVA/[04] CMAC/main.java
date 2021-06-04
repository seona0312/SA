public class main
{
    public static void main(String[] args)
    {
        byte[] key = new byte[16];
        byte[] msg = new byte[1000];
        byte[] mac = new byte[8];
        byte[] tag = new byte[8];
        int keyLen = 16, msgLen = 0, macLen = 16;

        KISA_HIGHT_CMAC hight_cmac = new KISA_HIGHT_CMAC();

        print_title("Test HIGHT CMAC - 1");

        keyLen = asc2hex(key, "F9C59DD0B28BB29B741BC650BE4186BB");
        msgLen = asc2hex(msg, "BDC99BB27AE87C9D53D78635A8C14E8BD6DF364C69E23E448D911D22C6B3917BE12FF3112B720E54E0113129E6AF");
        macLen = asc2hex(tag, "1726866576B73601");
    
        print_result("HIGHT Generate CMAC", hight_cmac.HIGHT_Generate_CMAC(mac, macLen, msg, msgLen, key));
    
        print_hex("key", key, keyLen);
        print_hex("msg", msg, msgLen);
        print_hex("mac", mac, macLen);
        print_hex("tag", tag, macLen);
    
        print_result("HIGHT Verify CMAC", hight_cmac.HIGHT_Verify_CMAC(tag, macLen, msg, msgLen, key));

        print_title("Test HIGHT CMAC - 2");

        keyLen = asc2hex(key, "5059620A3ADF4159C41B3F89F48A361E");
        msgLen = asc2hex(msg, "");
        macLen = asc2hex(tag, "5B796790481524D4");
    
        print_result("HIGHT Generate CMAC", hight_cmac.HIGHT_Generate_CMAC(mac, macLen, msg, msgLen, key));
    
        print_hex("key", key, keyLen);
        print_hex("msg", msg, msgLen);
        print_hex("mac", mac, macLen);
        print_hex("tag", tag, macLen);
    
        print_result("HIGHT Verify CMAC", hight_cmac.HIGHT_Verify_CMAC(tag, macLen, msg, msgLen, key));
    }

    private static int asc2hex(byte[] dst, String src)
    {
        byte temp = 0x00, hex = 0;
        int i = 0;
    
        for (i = 0; i < src.length(); i++)
        {
            temp = 0x00;
            hex = (byte)src.charAt(i);
    
            if ((hex >= 0x30) && (hex <= 0x39))
                temp = (byte)(hex - 0x30);
            else if ((hex >= 0x41) && (hex <= 0x5A))
                temp = (byte)(hex - 0x41 + 10);
            else if ((hex >= 0x61) && (hex <= 0x7A))
                temp = (byte)(hex - 0x61 + 10);
            else
                temp = 0x00;
            
            if ((i & 1) == 1)
                dst[i >> 1] ^= temp & 0x0F;
            else
                dst[i >> 1] = (byte)(temp << 4);
        }
    
        return ((i + 1) / 2);
    }

    private static void print_hex(String valName, byte[] data, int dataLen)
    {
        int i = 0;

        System.out.printf("%s [%dbyte] :", valName, dataLen);
        for (i = 0; i < dataLen; i++)
        {
            if ((i & 0x0F) == 0)
                System.out.println("");

            System.out.printf(" %02X", data[i]);
        }
        System.out.println("");
    }

    private static void print_title(String title)
    {
        System.out.println("================================================");
        System.out.println("  " + title);
        System.out.println("================================================");
    }

    private static void print_result(String func, int ret)
    {
        if (ret != 0)
        {
            System.out.println("================================================");
            System.out.println("  " + func + " Failure!");
            System.out.println("================================================");

            System.exit(0);
        }
        else
        {
            System.out.println("================================================");
            System.out.println("  " + func + " Success!");
            System.out.println("================================================");
        }
    }
}