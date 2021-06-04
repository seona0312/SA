#include <stdio.h>

void Display(unsigned char* Data, int sz)
{
  int i = 0;

  for (i = 0; i < sz; i++)
  {
    printf("%02X ", Data[i]);
  }
  printf("\n");
}


void split(char* name, char* mode)
{
  printf("+---------------------------------------------------------------------------------------+\n");
  printf("+                                                                                       +\n");
  printf("+                                     %4s:%5s                                        +\n", name, mode);
  printf("+                                                                                       +\n");
  printf("+---------------------------------------------------------------------------------------+\n");
}

void main()
{
  split("KISA", "ECB");
  KISA_HIGHT_ECB_main();
  split("LSA", "ECB");
  LSA_HIGHT_ECB_main();

  split("KISA", "CBC");
  KISA_HIGHT_CBC_main();
  split("LSA", "CBC");
  LSA_HIGHT_CBC_main();
}
