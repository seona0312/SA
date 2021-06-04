#ifndef _HIGHT_H_
#define _HIGHT_H_


// include header


// define
#define BLOCK_SIZE_HIGHT        8
#define WHITENING_KEY_SIZE      8

#define HIGHT_ENC(k, i0,i1,i2,i3,i4,i5,i6,i7) {                   \
    XX[i0] = (XX[i0] ^ (F0[XX[i1]] + rKey[4 * k + 3])) & 0xFF;    \
    XX[i2] = (XX[i2] + (F1[XX[i3]] ^ rKey[4 * k + 2])) & 0xFF;    \
    XX[i4] = (XX[i4] ^ (F0[XX[i5]] + rKey[4 * k + 1])) & 0xFF;    \
    XX[i6] = (XX[i6] + (F1[XX[i7]] ^ rKey[4 * k    ])) & 0xFF;    \
}

#define HIGHT_DEC(k, i0,i1,i2,i3,i4,i5,i6,i7) {                   \
    XX[i1] = (XX[i1] - (F1[XX[i2]] ^ rKey[4 * k + 2])) & 0xFF;    \
    XX[i3] = (XX[i3] ^ (F0[XX[i4]] + rKey[4 * k + 1])) & 0xFF;    \
    XX[i5] = (XX[i5] - (F1[XX[i6]] ^ rKey[4 * k    ])) & 0xFF;    \
    XX[i7] = (XX[i7] ^ (F0[XX[i0]] + rKey[4 * k + 3])) & 0xFF;    \
}


// function declare
#ifdef __cplusplus
extern "C" 
{
#endif
void HIGHT_KeySched(unsigned char *mKey, unsigned char *rKey);
void HIGHT_Encrypt(unsigned char *pOut, unsigned char *pIn, unsigned char *rKey);
void HIGHT_Decrypt(unsigned char *pOut, unsigned char *pIn, unsigned char *rKey);
#ifdef __cplusplus
}
#endif



#else
#endif
