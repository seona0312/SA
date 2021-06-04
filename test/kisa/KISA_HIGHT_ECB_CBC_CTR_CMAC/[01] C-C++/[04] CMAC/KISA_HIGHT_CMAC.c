#include "KISA_HIGHT.h"
#include "KISA_HIGHT_CMAC.h"


// CMAC Subkey Generate
void HIGHT_CMAC_SubkeySched(unsigned char *sKey)
{
    int i = 0, carry = sKey[0] >> 7;

    for (i = 0; i < 7; i++)
        sKey[i] = (sKey[i] << 1) | (sKey[i + 1] >> 7);

    sKey[i] = sKey[i] << 1;

    if (carry)
        sKey[i] ^= 0x1b;
}

// HIGHT Generate CMAC
int HIGHT_Generate_CMAC(unsigned char *pMAC, int macLen, unsigned char *pIn, int inLen, unsigned char *mKey)
{
    unsigned char temp[BLOCK_SIZE_HIGHT] = { 0x00, };
    unsigned char subKey[BLOCK_SIZE_HIGHT] = { 0x00, };
    unsigned char rKey[136] = { 0x00, };
    int blockLen = 0, i = 0, j = 0;

    if (macLen > BLOCK_SIZE_HIGHT)
        return 1;

    HIGHT_KeySched(mKey, rKey);
    HIGHT_Encrypt(subKey, subKey, rKey);

    // make K1
    HIGHT_CMAC_SubkeySched(subKey);

    if (inLen == 0)
    {
        // make K2
        HIGHT_CMAC_SubkeySched(subKey);

        subKey[0] ^= 0x80;

        HIGHT_Encrypt(temp, subKey, rKey);
    }
    else if (inLen & 7)
    {
        // make K2
        HIGHT_CMAC_SubkeySched(subKey);

        blockLen = (inLen + BLOCK_SIZE_HIGHT) / BLOCK_SIZE_HIGHT;

        for (i = 0; i < blockLen - 1; i++)
        {
            for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j];

            HIGHT_Encrypt(temp, temp, rKey);
        }

        for (j = 0; (BLOCK_SIZE_HIGHT * i + j) < inLen; j++)
            temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j] ^ subKey[j];
        temp[j] ^= 0x80 ^ subKey[j];
        for (j += 1; j < BLOCK_SIZE_HIGHT; j++)
            temp[j] ^= subKey[j];

        HIGHT_Encrypt(temp, temp, rKey);
    }
    else
    {
        blockLen = inLen / BLOCK_SIZE_HIGHT;

        for (i = 0; i < blockLen - 1; i++)
        {
            for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j];

            HIGHT_Encrypt(temp, temp, rKey);
        }

        for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
            temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j] ^ subKey[j];

        HIGHT_Encrypt(temp, temp, rKey);

    }

    for (i = 0; i < macLen; i++)
        pMAC[i] = temp[i];
    
    return 0;
}

// HIGHT Verify CMAC
int HIGHT_Verify_CMAC(unsigned char *pMAC, int macLen, unsigned char *pIn, int inLen, unsigned char *mKey)
{
    unsigned char temp[BLOCK_SIZE_HIGHT] = { 0x00, };
    unsigned char subKey[BLOCK_SIZE_HIGHT] = { 0x00, };
    unsigned char rKey[136] = { 0x00, };
    int blockLen = 0, i = 0, j = 0;

    if (macLen > BLOCK_SIZE_HIGHT)
        return 1;

    HIGHT_KeySched(mKey, rKey);
    HIGHT_Encrypt(subKey, subKey, rKey);

    // make K1
    HIGHT_CMAC_SubkeySched(subKey);

    if (inLen == 0)
    {
        // make K2
        HIGHT_CMAC_SubkeySched(subKey);

        subKey[0] ^= 0x80;

        HIGHT_Encrypt(temp, subKey, rKey);
    }
    else if (inLen & 7)
    {
        // make K2
        HIGHT_CMAC_SubkeySched(subKey);

        blockLen = (inLen + BLOCK_SIZE_HIGHT) / BLOCK_SIZE_HIGHT;

        for (i = 0; i < blockLen - 1; i++)
        {
            for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j];

            HIGHT_Encrypt(temp, temp, rKey);
        }

        for (j = 0; (BLOCK_SIZE_HIGHT * i + j) < inLen; j++)
            temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j] ^ subKey[j];
        temp[j] ^= 0x80 ^ subKey[j];
        for (j += 1; j < BLOCK_SIZE_HIGHT; j++)
            temp[j] ^= subKey[j];

        HIGHT_Encrypt(temp, temp, rKey);
    }
    else
    {
        blockLen = inLen / BLOCK_SIZE_HIGHT;

        for (i = 0; i < blockLen - 1; i++)
        {
            for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
                temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j];

            HIGHT_Encrypt(temp, temp, rKey);
        }

        for (j = 0; j < BLOCK_SIZE_HIGHT; j++)
            temp[j] ^= pIn[BLOCK_SIZE_HIGHT * i + j] ^ subKey[j];

        HIGHT_Encrypt(temp, temp, rKey);

    }

    for (i = 0; i < macLen; i++)
        if (pMAC[i] != temp[i])
            return 1;
    
    return 0;
}
