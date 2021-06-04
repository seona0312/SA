public class KISA_HIGHT_CMAC
{
    private static final int BLOCK_SIZE_HIGHT = 8;

    private void HIGHT_CMAC_SubkeySched(byte[] sKey)
    {
        int temp1, temp2;
        int i = 0, carry = (sKey[0] & 0x0FF) >> 7;
    
        for (i = 0; i < 7; i++)
        {
            temp1 = (sKey[i    ] & 0x0FF) << 1;
            temp2 = (sKey[i + 1] & 0x0FF) >> 7;

            sKey[i] = (byte)(temp1 | temp2);
        }
    
        sKey[i] = (byte)(sKey[i] << 1);
    

        if (carry == 1)
            sKey[i] ^= 0x1b;
    }

    public int HIGHT_Generate_CMAC(byte[] pMAC, int macLen, byte[] pIn, int inLen, byte[] mKey)
    {
        byte[] temp = new byte[BLOCK_SIZE_HIGHT];
        byte[] subKey = new byte[BLOCK_SIZE_HIGHT];
        byte[] rKey = new byte[136];
        int blockLen = 0, i = 0, j = 0;

        KISA_HIGHT hight = new KISA_HIGHT();
    
        if (macLen > BLOCK_SIZE_HIGHT)
            return 1;
    
        hight.HIGHT_KeySched(mKey, rKey);
        hight.HIGHT_Encrypt(subKey, subKey, rKey);
    
        // make K1
        HIGHT_CMAC_SubkeySched(subKey);
    
        if (inLen == 0)
        {
            // make K2
            HIGHT_CMAC_SubkeySched(subKey);
    
            subKey[0] ^= 0x80;
    
            hight.HIGHT_Encrypt(temp, subKey, rKey);
        }
        else if ((inLen & 7) != 0)
        {
            // make K2
            HIGHT_CMAC_SubkeySched(subKey);
    
            blockLen = (inLen + BLOCK_SIZE_HIGHT) / BLOCK_SIZE_HIGHT;
    
            for (i = 0; i < blockLen - 1; i++)
            {
                for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                    temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j];
    
                hight.HIGHT_Encrypt(temp, temp, rKey);
            }
    
            for (j = 0; (BLOCK_SIZE_HIGHT * i + j) < inLen; j++)
                temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j] ^ subKey[j];
            temp[j] ^= 0x80 ^ subKey[j];
            for (j += 1; j < BLOCK_SIZE_HIGHT; j++)
                temp[j] ^= subKey[j];
    
                hight.HIGHT_Encrypt(temp, temp, rKey);
        }
        else
        {
            blockLen = inLen / BLOCK_SIZE_HIGHT;
    
            for (i = 0; i < blockLen - 1; i++)
            {
                for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                    temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j];
    
                    hight.HIGHT_Encrypt(temp, temp, rKey);
            }
    
            for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j] ^ subKey[j];
    
                hight.HIGHT_Encrypt(temp, temp, rKey);
    
        }
    
        for (i = 0; i < macLen; i++)
            pMAC[i] = temp[i];
        
        return 0;
    }

    public int HIGHT_Verify_CMAC(byte[] pMAC, int macLen, byte[] pIn, int inLen, byte[] mKey)
    {
        byte[] temp = new byte[BLOCK_SIZE_HIGHT];
        byte[] subKey = new byte[BLOCK_SIZE_HIGHT];
        byte[] rKey = new byte[136];
        int blockLen = 0, i = 0, j = 0;

        KISA_HIGHT hight = new KISA_HIGHT();
    
        if (macLen > BLOCK_SIZE_HIGHT)
            return 1;
    
        hight.HIGHT_KeySched(mKey, rKey);
        hight.HIGHT_Encrypt(subKey, subKey, rKey);
    
        // make K1
        HIGHT_CMAC_SubkeySched(subKey);
    
        if (inLen == 0)
        {
            // make K2
            HIGHT_CMAC_SubkeySched(subKey);
    
            subKey[0] ^= 0x80;
    
            hight.HIGHT_Encrypt(temp, subKey, rKey);
        }
        else if ((inLen & 7) != 0)
        {
            // make K2
            HIGHT_CMAC_SubkeySched(subKey);
    
            blockLen = (inLen + BLOCK_SIZE_HIGHT) / BLOCK_SIZE_HIGHT;
    
            for (i = 0; i < blockLen - 1; i++)
            {
                for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                    temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j];
    
                    hight.HIGHT_Encrypt(temp, temp, rKey);
            }
    
            for (j = 0; (BLOCK_SIZE_HIGHT * i + j) < inLen; j++)
                temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j] ^ subKey[j];

            temp[j] ^= 0x80 ^ subKey[j];

            for (j += 1; j < BLOCK_SIZE_HIGHT; j++)
                temp[j] ^= subKey[j];
    
            hight.HIGHT_Encrypt(temp, temp, rKey);
        }
        else
        {
            blockLen = inLen / BLOCK_SIZE_HIGHT;
    
            for (i = 0; i < blockLen - 1; i++)
            {
                for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                    temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j];
    
                hight.HIGHT_Encrypt(temp, temp, rKey);
            }
    
            for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j] ^ subKey[j];
    
                hight.HIGHT_Encrypt(temp, temp, rKey);
    
        }

        for (i = 0; i < macLen; i++)
            if (pMAC[i] != temp[i])
                return 1;

        return 0;
    }
}