public class KISA_HIGHT
{
    private static final byte[] Delta = new byte[]
    {
        (byte)0x5A,(byte)0x6D,(byte)0x36,(byte)0x1B,(byte)0x0D,(byte)0x06,(byte)0x03,(byte)0x41,
        (byte)0x60,(byte)0x30,(byte)0x18,(byte)0x4C,(byte)0x66,(byte)0x33,(byte)0x59,(byte)0x2C,
        (byte)0x56,(byte)0x2B,(byte)0x15,(byte)0x4A,(byte)0x65,(byte)0x72,(byte)0x39,(byte)0x1C,
        (byte)0x4E,(byte)0x67,(byte)0x73,(byte)0x79,(byte)0x3C,(byte)0x5E,(byte)0x6F,(byte)0x37,
        (byte)0x5B,(byte)0x2D,(byte)0x16,(byte)0x0B,(byte)0x05,(byte)0x42,(byte)0x21,(byte)0x50,
        (byte)0x28,(byte)0x54,(byte)0x2A,(byte)0x55,(byte)0x6A,(byte)0x75,(byte)0x7A,(byte)0x7D,
        (byte)0x3E,(byte)0x5F,(byte)0x2F,(byte)0x17,(byte)0x4B,(byte)0x25,(byte)0x52,(byte)0x29,
        (byte)0x14,(byte)0x0A,(byte)0x45,(byte)0x62,(byte)0x31,(byte)0x58,(byte)0x6C,(byte)0x76,
        (byte)0x3B,(byte)0x1D,(byte)0x0E,(byte)0x47,(byte)0x63,(byte)0x71,(byte)0x78,(byte)0x7C,
        (byte)0x7E,(byte)0x7F,(byte)0x3F,(byte)0x1F,(byte)0x0F,(byte)0x07,(byte)0x43,(byte)0x61,
        (byte)0x70,(byte)0x38,(byte)0x5C,(byte)0x6E,(byte)0x77,(byte)0x7B,(byte)0x3D,(byte)0x1E,
        (byte)0x4F,(byte)0x27,(byte)0x53,(byte)0x69,(byte)0x34,(byte)0x1A,(byte)0x4D,(byte)0x26,
        (byte)0x13,(byte)0x49,(byte)0x24,(byte)0x12,(byte)0x09,(byte)0x04,(byte)0x02,(byte)0x01,
        (byte)0x40,(byte)0x20,(byte)0x10,(byte)0x08,(byte)0x44,(byte)0x22,(byte)0x11,(byte)0x48,
        (byte)0x64,(byte)0x32,(byte)0x19,(byte)0x0C,(byte)0x46,(byte)0x23,(byte)0x51,(byte)0x68,
        (byte)0x74,(byte)0x3A,(byte)0x5D,(byte)0x2E,(byte)0x57,(byte)0x6B,(byte)0x35,(byte)0x5A
    };

    private static final byte F0[] = new byte[] 
    {
        (byte)0x00,(byte)0x86,(byte)0x0D,(byte)0x8B,(byte)0x1A,(byte)0x9C,(byte)0x17,(byte)0x91,
        (byte)0x34,(byte)0xB2,(byte)0x39,(byte)0xBF,(byte)0x2E,(byte)0xA8,(byte)0x23,(byte)0xA5,
        (byte)0x68,(byte)0xEE,(byte)0x65,(byte)0xE3,(byte)0x72,(byte)0xF4,(byte)0x7F,(byte)0xF9,
        (byte)0x5C,(byte)0xDA,(byte)0x51,(byte)0xD7,(byte)0x46,(byte)0xC0,(byte)0x4B,(byte)0xCD,
        (byte)0xD0,(byte)0x56,(byte)0xDD,(byte)0x5B,(byte)0xCA,(byte)0x4C,(byte)0xC7,(byte)0x41,
        (byte)0xE4,(byte)0x62,(byte)0xE9,(byte)0x6F,(byte)0xFE,(byte)0x78,(byte)0xF3,(byte)0x75,
        (byte)0xB8,(byte)0x3E,(byte)0xB5,(byte)0x33,(byte)0xA2,(byte)0x24,(byte)0xAF,(byte)0x29,
        (byte)0x8C,(byte)0x0A,(byte)0x81,(byte)0x07,(byte)0x96,(byte)0x10,(byte)0x9B,(byte)0x1D,
        (byte)0xA1,(byte)0x27,(byte)0xAC,(byte)0x2A,(byte)0xBB,(byte)0x3D,(byte)0xB6,(byte)0x30,
        (byte)0x95,(byte)0x13,(byte)0x98,(byte)0x1E,(byte)0x8F,(byte)0x09,(byte)0x82,(byte)0x04,
        (byte)0xC9,(byte)0x4F,(byte)0xC4,(byte)0x42,(byte)0xD3,(byte)0x55,(byte)0xDE,(byte)0x58,
        (byte)0xFD,(byte)0x7B,(byte)0xF0,(byte)0x76,(byte)0xE7,(byte)0x61,(byte)0xEA,(byte)0x6C,
        (byte)0x71,(byte)0xF7,(byte)0x7C,(byte)0xFA,(byte)0x6B,(byte)0xED,(byte)0x66,(byte)0xE0,
        (byte)0x45,(byte)0xC3,(byte)0x48,(byte)0xCE,(byte)0x5F,(byte)0xD9,(byte)0x52,(byte)0xD4,
        (byte)0x19,(byte)0x9F,(byte)0x14,(byte)0x92,(byte)0x03,(byte)0x85,(byte)0x0E,(byte)0x88,
        (byte)0x2D,(byte)0xAB,(byte)0x20,(byte)0xA6,(byte)0x37,(byte)0xB1,(byte)0x3A,(byte)0xBC,
        (byte)0x43,(byte)0xC5,(byte)0x4E,(byte)0xC8,(byte)0x59,(byte)0xDF,(byte)0x54,(byte)0xD2,
        (byte)0x77,(byte)0xF1,(byte)0x7A,(byte)0xFC,(byte)0x6D,(byte)0xEB,(byte)0x60,(byte)0xE6,
        (byte)0x2B,(byte)0xAD,(byte)0x26,(byte)0xA0,(byte)0x31,(byte)0xB7,(byte)0x3C,(byte)0xBA,
        (byte)0x1F,(byte)0x99,(byte)0x12,(byte)0x94,(byte)0x05,(byte)0x83,(byte)0x08,(byte)0x8E,
        (byte)0x93,(byte)0x15,(byte)0x9E,(byte)0x18,(byte)0x89,(byte)0x0F,(byte)0x84,(byte)0x02,
        (byte)0xA7,(byte)0x21,(byte)0xAA,(byte)0x2C,(byte)0xBD,(byte)0x3B,(byte)0xB0,(byte)0x36,
        (byte)0xFB,(byte)0x7D,(byte)0xF6,(byte)0x70,(byte)0xE1,(byte)0x67,(byte)0xEC,(byte)0x6A,
        (byte)0xCF,(byte)0x49,(byte)0xC2,(byte)0x44,(byte)0xD5,(byte)0x53,(byte)0xD8,(byte)0x5E,
        (byte)0xE2,(byte)0x64,(byte)0xEF,(byte)0x69,(byte)0xF8,(byte)0x7E,(byte)0xF5,(byte)0x73,
        (byte)0xD6,(byte)0x50,(byte)0xDB,(byte)0x5D,(byte)0xCC,(byte)0x4A,(byte)0xC1,(byte)0x47,
        (byte)0x8A,(byte)0x0C,(byte)0x87,(byte)0x01,(byte)0x90,(byte)0x16,(byte)0x9D,(byte)0x1B,
        (byte)0xBE,(byte)0x38,(byte)0xB3,(byte)0x35,(byte)0xA4,(byte)0x22,(byte)0xA9,(byte)0x2F,
        (byte)0x32,(byte)0xB4,(byte)0x3F,(byte)0xB9,(byte)0x28,(byte)0xAE,(byte)0x25,(byte)0xA3,
        (byte)0x06,(byte)0x80,(byte)0x0B,(byte)0x8D,(byte)0x1C,(byte)0x9A,(byte)0x11,(byte)0x97,
        (byte)0x5A,(byte)0xDC,(byte)0x57,(byte)0xD1,(byte)0x40,(byte)0xC6,(byte)0x4D,(byte)0xCB,
        (byte)0x6E,(byte)0xE8,(byte)0x63,(byte)0xE5,(byte)0x74,(byte)0xF2,(byte)0x79,(byte)0xFF
    };

    private static final byte F1[] = new byte[] 
    {
        (byte)0x00,(byte)0x58,(byte)0xB0,(byte)0xE8,(byte)0x61,(byte)0x39,(byte)0xD1,(byte)0x89,
        (byte)0xC2,(byte)0x9A,(byte)0x72,(byte)0x2A,(byte)0xA3,(byte)0xFB,(byte)0x13,(byte)0x4B,
        (byte)0x85,(byte)0xDD,(byte)0x35,(byte)0x6D,(byte)0xE4,(byte)0xBC,(byte)0x54,(byte)0x0C,
        (byte)0x47,(byte)0x1F,(byte)0xF7,(byte)0xAF,(byte)0x26,(byte)0x7E,(byte)0x96,(byte)0xCE,
        (byte)0x0B,(byte)0x53,(byte)0xBB,(byte)0xE3,(byte)0x6A,(byte)0x32,(byte)0xDA,(byte)0x82,
        (byte)0xC9,(byte)0x91,(byte)0x79,(byte)0x21,(byte)0xA8,(byte)0xF0,(byte)0x18,(byte)0x40,
        (byte)0x8E,(byte)0xD6,(byte)0x3E,(byte)0x66,(byte)0xEF,(byte)0xB7,(byte)0x5F,(byte)0x07,
        (byte)0x4C,(byte)0x14,(byte)0xFC,(byte)0xA4,(byte)0x2D,(byte)0x75,(byte)0x9D,(byte)0xC5,
        (byte)0x16,(byte)0x4E,(byte)0xA6,(byte)0xFE,(byte)0x77,(byte)0x2F,(byte)0xC7,(byte)0x9F,
        (byte)0xD4,(byte)0x8C,(byte)0x64,(byte)0x3C,(byte)0xB5,(byte)0xED,(byte)0x05,(byte)0x5D,
        (byte)0x93,(byte)0xCB,(byte)0x23,(byte)0x7B,(byte)0xF2,(byte)0xAA,(byte)0x42,(byte)0x1A,
        (byte)0x51,(byte)0x09,(byte)0xE1,(byte)0xB9,(byte)0x30,(byte)0x68,(byte)0x80,(byte)0xD8,
        (byte)0x1D,(byte)0x45,(byte)0xAD,(byte)0xF5,(byte)0x7C,(byte)0x24,(byte)0xCC,(byte)0x94,
        (byte)0xDF,(byte)0x87,(byte)0x6F,(byte)0x37,(byte)0xBE,(byte)0xE6,(byte)0x0E,(byte)0x56,
        (byte)0x98,(byte)0xC0,(byte)0x28,(byte)0x70,(byte)0xF9,(byte)0xA1,(byte)0x49,(byte)0x11,
        (byte)0x5A,(byte)0x02,(byte)0xEA,(byte)0xB2,(byte)0x3B,(byte)0x63,(byte)0x8B,(byte)0xD3,
        (byte)0x2C,(byte)0x74,(byte)0x9C,(byte)0xC4,(byte)0x4D,(byte)0x15,(byte)0xFD,(byte)0xA5,
        (byte)0xEE,(byte)0xB6,(byte)0x5E,(byte)0x06,(byte)0x8F,(byte)0xD7,(byte)0x3F,(byte)0x67,
        (byte)0xA9,(byte)0xF1,(byte)0x19,(byte)0x41,(byte)0xC8,(byte)0x90,(byte)0x78,(byte)0x20,
        (byte)0x6B,(byte)0x33,(byte)0xDB,(byte)0x83,(byte)0x0A,(byte)0x52,(byte)0xBA,(byte)0xE2,
        (byte)0x27,(byte)0x7F,(byte)0x97,(byte)0xCF,(byte)0x46,(byte)0x1E,(byte)0xF6,(byte)0xAE,
        (byte)0xE5,(byte)0xBD,(byte)0x55,(byte)0x0D,(byte)0x84,(byte)0xDC,(byte)0x34,(byte)0x6C,
        (byte)0xA2,(byte)0xFA,(byte)0x12,(byte)0x4A,(byte)0xC3,(byte)0x9B,(byte)0x73,(byte)0x2B,
        (byte)0x60,(byte)0x38,(byte)0xD0,(byte)0x88,(byte)0x01,(byte)0x59,(byte)0xB1,(byte)0xE9,
        (byte)0x3A,(byte)0x62,(byte)0x8A,(byte)0xD2,(byte)0x5B,(byte)0x03,(byte)0xEB,(byte)0xB3,
        (byte)0xF8,(byte)0xA0,(byte)0x48,(byte)0x10,(byte)0x99,(byte)0xC1,(byte)0x29,(byte)0x71,
        (byte)0xBF,(byte)0xE7,(byte)0x0F,(byte)0x57,(byte)0xDE,(byte)0x86,(byte)0x6E,(byte)0x36,
        (byte)0x7D,(byte)0x25,(byte)0xCD,(byte)0x95,(byte)0x1C,(byte)0x44,(byte)0xAC,(byte)0xF4,
        (byte)0x31,(byte)0x69,(byte)0x81,(byte)0xD9,(byte)0x50,(byte)0x08,(byte)0xE0,(byte)0xB8,
        (byte)0xF3,(byte)0xAB,(byte)0x43,(byte)0x1B,(byte)0x92,(byte)0xCA,(byte)0x22,(byte)0x7A,
        (byte)0xB4,(byte)0xEC,(byte)0x04,(byte)0x5C,(byte)0xD5,(byte)0x8D,(byte)0x65,(byte)0x3D,
        (byte)0x76,(byte)0x2E,(byte)0xC6,(byte)0x9E,(byte)0x17,(byte)0x4F,(byte)0xA7,(byte)0xFF
    };

    private static final int BLOCK_SIZE_HIGHT = 8;
    private static final int WHITENING_KEY_SIZE = 8;

    private static void HIGHT_ENC(int[] XX, int i0, int i1, int i2, int i3, int i4, int i5, int i6, int i7, byte[] rKey, int offset)
    {
        XX[i0] = (XX[i0] ^ ((F0[XX[i1]] + rKey[4 * offset + 3]) & 0x0FF)) & 0x0FF;
        XX[i2] = (XX[i2] + ((F1[XX[i3]] ^ rKey[4 * offset + 2]) & 0x0FF)) & 0x0FF;
        XX[i4] = (XX[i4] ^ ((F0[XX[i5]] + rKey[4 * offset + 1]) & 0x0FF)) & 0x0FF;
        XX[i6] = (XX[i6] + ((F1[XX[i7]] ^ rKey[4 * offset    ]) & 0x0FF)) & 0x0FF;
    }

    private static void HIGHT_DEC(int[] XX, int i0, int i1, int i2, int i3, int i4, int i5, int i6, int i7, byte[] rKey, int offset)
    {
        XX[i1] = (XX[i1] - ((F1[XX[i2]] ^ rKey[4 * offset + 2]) & 0x0FF)) & 0x0FF;
        XX[i3] = (XX[i3] ^ ((F0[XX[i4]] + rKey[4 * offset + 1]) & 0x0FF)) & 0x0FF;
        XX[i5] = (XX[i5] - ((F1[XX[i6]] ^ rKey[4 * offset    ]) & 0x0FF)) & 0x0FF;
        XX[i7] = (XX[i7] ^ ((F0[XX[i0]] + rKey[4 * offset + 3]) & 0x0FF)) & 0x0FF;
    }

    public void HIGHT_KeySched(byte[] mKey, byte[] rKey)
    {
        int i = 0, j = 0;

        for (i = 0; i < 4; i++)
        {
            rKey[i    ] = mKey[i + 12];
            rKey[i + 4] = mKey[i     ];
        }

        for (i = 0; i < BLOCK_SIZE_HIGHT; i++)
        {
            for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                rKey[WHITENING_KEY_SIZE + 16 * i + j    ] = (byte)(mKey[ (j - i) & 7     ] + Delta[16 * i + j    ]);

            for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                rKey[WHITENING_KEY_SIZE + 16 * i + j + 8] = (byte)(mKey[((j - i) & 7) + 8] + Delta[16 * i + j + 8]);
        }
    }

    public void HIGHT_Encrypt(byte[] pOut, byte[] pIn, byte[] rKey)
    {
        int[] XX = new int[8];
    
        XX[1] = pIn[1];
        XX[3] = pIn[3];
        XX[5] = pIn[5];
        XX[7] = pIn[7];
    
        XX[0] = (pIn[0] + rKey[0]) & 0x0FF;
        XX[2] = (pIn[2] ^ rKey[1]) & 0x0FF;
        XX[4] = (pIn[4] + rKey[2]) & 0x0FF;
        XX[6] = (pIn[6] ^ rKey[3]) & 0x0FF;
    
        HIGHT_ENC(XX,7,6,5,4,3,2,1,0, rKey, 2);
        HIGHT_ENC(XX,6,5,4,3,2,1,0,7, rKey, 3);
        HIGHT_ENC(XX,5,4,3,2,1,0,7,6, rKey, 4);
        HIGHT_ENC(XX,4,3,2,1,0,7,6,5, rKey, 5);
        HIGHT_ENC(XX,3,2,1,0,7,6,5,4, rKey, 6);
        HIGHT_ENC(XX,2,1,0,7,6,5,4,3, rKey, 7);
        HIGHT_ENC(XX,1,0,7,6,5,4,3,2, rKey, 8);
        HIGHT_ENC(XX,0,7,6,5,4,3,2,1, rKey, 9);
        HIGHT_ENC(XX,7,6,5,4,3,2,1,0, rKey,10);
        HIGHT_ENC(XX,6,5,4,3,2,1,0,7, rKey,11);
        HIGHT_ENC(XX,5,4,3,2,1,0,7,6, rKey,12);
        HIGHT_ENC(XX,4,3,2,1,0,7,6,5, rKey,13);
        HIGHT_ENC(XX,3,2,1,0,7,6,5,4, rKey,14);
        HIGHT_ENC(XX,2,1,0,7,6,5,4,3, rKey,15);
        HIGHT_ENC(XX,1,0,7,6,5,4,3,2, rKey,16);
        HIGHT_ENC(XX,0,7,6,5,4,3,2,1, rKey,17);
        HIGHT_ENC(XX,7,6,5,4,3,2,1,0, rKey,18);
        HIGHT_ENC(XX,6,5,4,3,2,1,0,7, rKey,19);
        HIGHT_ENC(XX,5,4,3,2,1,0,7,6, rKey,20);
        HIGHT_ENC(XX,4,3,2,1,0,7,6,5, rKey,21);
        HIGHT_ENC(XX,3,2,1,0,7,6,5,4, rKey,22);
        HIGHT_ENC(XX,2,1,0,7,6,5,4,3, rKey,23);
        HIGHT_ENC(XX,1,0,7,6,5,4,3,2, rKey,24);
        HIGHT_ENC(XX,0,7,6,5,4,3,2,1, rKey,25);
        HIGHT_ENC(XX,7,6,5,4,3,2,1,0, rKey,26);
        HIGHT_ENC(XX,6,5,4,3,2,1,0,7, rKey,27);
        HIGHT_ENC(XX,5,4,3,2,1,0,7,6, rKey,28);
        HIGHT_ENC(XX,4,3,2,1,0,7,6,5, rKey,29);
        HIGHT_ENC(XX,3,2,1,0,7,6,5,4, rKey,30);
        HIGHT_ENC(XX,2,1,0,7,6,5,4,3, rKey,31);
        HIGHT_ENC(XX,1,0,7,6,5,4,3,2, rKey,32);
        HIGHT_ENC(XX,0,7,6,5,4,3,2,1, rKey,33);
    
        pOut[1] = (byte)XX[2];
        pOut[3] = (byte)XX[4];
        pOut[5] = (byte)XX[6];
        pOut[7] = (byte)XX[0];
    
        pOut[0] = (byte)(XX[1] + rKey[4]);
        pOut[2] = (byte)(XX[3] ^ rKey[5]);
        pOut[4] = (byte)(XX[5] + rKey[6]);
        pOut[6] = (byte)(XX[7] ^ rKey[7]);
    }

    public void HIGHT_Decrypt(byte[] pOut, byte[] pIn, byte[] rKey)
    {
        int[] XX = new int[8];

        XX[2] = pIn[1];
        XX[4] = pIn[3];
        XX[6] = pIn[5];
        XX[0] = pIn[7];
    
        XX[1] = (pIn[0] - rKey[4]) & 0x0FF;
        XX[3] = (pIn[2] ^ rKey[5]) & 0x0FF;
        XX[5] = (pIn[4] - rKey[6]) & 0x0FF;
        XX[7] = (pIn[6] ^ rKey[7]) & 0x0FF;
    
        HIGHT_DEC(XX,7,6,5,4,3,2,1,0, rKey,33);
        HIGHT_DEC(XX,0,7,6,5,4,3,2,1, rKey,32);
        HIGHT_DEC(XX,1,0,7,6,5,4,3,2, rKey,31);
        HIGHT_DEC(XX,2,1,0,7,6,5,4,3, rKey,30);
        HIGHT_DEC(XX,3,2,1,0,7,6,5,4, rKey,29);
        HIGHT_DEC(XX,4,3,2,1,0,7,6,5, rKey,28);
        HIGHT_DEC(XX,5,4,3,2,1,0,7,6, rKey,27);
        HIGHT_DEC(XX,6,5,4,3,2,1,0,7, rKey,26);
        HIGHT_DEC(XX,7,6,5,4,3,2,1,0, rKey,25);
        HIGHT_DEC(XX,0,7,6,5,4,3,2,1, rKey,24);
        HIGHT_DEC(XX,1,0,7,6,5,4,3,2, rKey,23);
        HIGHT_DEC(XX,2,1,0,7,6,5,4,3, rKey,22);
        HIGHT_DEC(XX,3,2,1,0,7,6,5,4, rKey,21);
        HIGHT_DEC(XX,4,3,2,1,0,7,6,5, rKey,20);
        HIGHT_DEC(XX,5,4,3,2,1,0,7,6, rKey,19);
        HIGHT_DEC(XX,6,5,4,3,2,1,0,7, rKey,18);
        HIGHT_DEC(XX,7,6,5,4,3,2,1,0, rKey,17);
        HIGHT_DEC(XX,0,7,6,5,4,3,2,1, rKey,16);
        HIGHT_DEC(XX,1,0,7,6,5,4,3,2, rKey,15);
        HIGHT_DEC(XX,2,1,0,7,6,5,4,3, rKey,14);
        HIGHT_DEC(XX,3,2,1,0,7,6,5,4, rKey,13);
        HIGHT_DEC(XX,4,3,2,1,0,7,6,5, rKey,12);
        HIGHT_DEC(XX,5,4,3,2,1,0,7,6, rKey,11);
        HIGHT_DEC(XX,6,5,4,3,2,1,0,7, rKey,10);
        HIGHT_DEC(XX,7,6,5,4,3,2,1,0, rKey, 9);
        HIGHT_DEC(XX,0,7,6,5,4,3,2,1, rKey, 8);
        HIGHT_DEC(XX,1,0,7,6,5,4,3,2, rKey, 7);
        HIGHT_DEC(XX,2,1,0,7,6,5,4,3, rKey, 6);
        HIGHT_DEC(XX,3,2,1,0,7,6,5,4, rKey, 5);
        HIGHT_DEC(XX,4,3,2,1,0,7,6,5, rKey, 4);
        HIGHT_DEC(XX,5,4,3,2,1,0,7,6, rKey, 3);
        HIGHT_DEC(XX,6,5,4,3,2,1,0,7, rKey, 2);
    
        pOut[1] = (byte)(XX[1]);
        pOut[3] = (byte)(XX[3]);
        pOut[5] = (byte)(XX[5]);
        pOut[7] = (byte)(XX[7]);
    
        pOut[0] = (byte)(XX[0] - rKey[0]);
        pOut[2] = (byte)(XX[2] ^ rKey[1]);
        pOut[4] = (byte)(XX[4] - rKey[2]);
        pOut[6] = (byte)(XX[6] ^ rKey[3]);
    }
}