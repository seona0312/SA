#ifndef _HIGHT_CMAC_H_
#define _HIGHT_CMAC_H_


// include header


// define


// function declare
#ifdef __cplusplus
extern "C" 
{
#endif
int HIGHT_Generate_CMAC(unsigned char *pMAC, int macLen, unsigned char *pIn, int inLen, unsigned char *mKey);
int HIGHT_Verify_CMAC(unsigned char *pMAC, int macLen, unsigned char *pIn, int inLen, unsigned char *mKey);
#ifdef __cplusplus
}
#endif



#else
#endif
