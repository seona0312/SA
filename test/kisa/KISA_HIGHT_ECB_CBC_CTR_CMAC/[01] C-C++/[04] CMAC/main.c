#include <stdio.h>
#include <stdlib.h>
#include "KISA_HIGHT.h"
#include "KISA_HIGHT_CMAC.h"

int asc2hex(unsigned char *dst, const char *src);
void print_title(const char *title);
void print_hex(const char *valName, const unsigned char *data, const int dataLen);
void print_result(const char *func, int ret);

int main()
{
    unsigned char key[16] = { 0x00, };
    unsigned char rKey[136] = { 0x00, };
    unsigned char msg[1000] = { 0x00, };
    unsigned char mac[8] = { 0x00, };
    unsigned char tag[8] = { 0x00, };
    int keyLen = 16, msgLen = 0, macLen = 8;

    /*print_title("Test HIGHT CMAC - 1!");
    
    keyLen = asc2hex(key, "F9C59DD0B28BB29B741BC650BE4186BB");
    msgLen = asc2hex(msg, "BDC99BB27AE87C9D53D78635A8C14E8BD6DF364C69E23E448D911D22C6B3917BE12FF3112B720E54E0113129E6AF");
    macLen = asc2hex(tag, "1726866576B73601");

    print_result("HIGHT Generate CMAC", HIGHT_Generate_CMAC(mac, macLen, msg, msgLen, key));

    print_hex("key", key, keyLen);
    print_hex("msg", msg, msgLen);
    print_hex("mac", mac, macLen);
    print_hex("tag", tag, macLen);
    
    print_result("HIGHT Verify CMAC",HIGHT_Verify_CMAC(tag, macLen, msg, msgLen, key));*/

    print_title("Test HIGHT CMAC - 2!");
    
    keyLen = asc2hex(key, "5059620A3ADF4159C41B3F89F48A361E");
    msgLen = asc2hex(msg, "");
    macLen = asc2hex(tag, "5B796790481524D4");

    print_result("HIGHT Generate CMAC", HIGHT_Generate_CMAC(mac, macLen, msg, msgLen, key));

    print_hex("key", key, keyLen);
    print_hex("msg", msg, msgLen);
    print_hex("mac", mac, macLen);
    print_hex("tag", tag, macLen);

    print_result("HIGHT Verify CMAC",HIGHT_Verify_CMAC(tag, macLen, msg, msgLen, key));
    
    return 0;
}


int asc2hex(unsigned char *dst, const char *src)
{
    unsigned char temp = 0x00;
    int i = 0;

    while (src[i] != 0x00)
    {
        temp = 0x00;

        if ((src[i] >= 0x30) && (src[i] <= 0x39))
            temp = src[i] - '0';
        else if ((src[i] >= 0x41) && (src[i] <= 0x5A))
            temp = src[i] - 'A' + 10;
        else if ((src[i] >= 0x61) && (src[i] <= 0x7A))
            temp = src[i] - 'a' + 10;
        else
            temp = 0x00;

        (i & 1) ? (dst[i >> 1] ^= temp & 0x0F) : (dst[i >> 1] = 0, dst[i >> 1] = temp << 4);

        i++;
    }

    return ((i + 1) / 2);
}


void print_title(const char *title)
{
    printf("================================================\n");
    printf("  %s\n", title);
    printf("================================================\n");
}


void print_hex(const char *valName, const unsigned char *data, const int dataLen)
{
    int i = 0;

    printf("%s [%dbyte] :", valName, dataLen);
    for (i = 0; i < dataLen; i++)
    {
        if (!(i & 0x0F))
            printf("\n");
        printf(" %02X", data[i]);
    }
    printf("\n");
}

void print_result(const char *func, int ret)
{
    if (ret)
    {
        printf("================================================\n");
        printf("  %s Failure!\n", func);
        printf("================================================\n");

        exit(0);
    }
    else
    {
        printf("================================================\n");
        printf("  %s Success!\n", func);
        printf("================================================\n");
    }
}
