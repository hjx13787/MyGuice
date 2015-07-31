#include <jni.h>
#include <stdio.h>
#include <windows.h>

struct HY_RECT_S
{
	long lLeft;
	long lRight;
	long lTop;
	long lBottom;
};

struct ID_CARD_S
{
	char szText[10][256];
	struct HY_RECT_S idRect[10];
};

struct JL_ITEM
{
	char pzTxt[256];
	long left;
	long top;
	long right;
	long bottom;
};

struct TERMB_ITEM
{
	char pzTxt[70][128];
};

//�Ƿ�װ����֤ģ��
typedef long (__stdcall *x_Device_IsCanReadTwoCard)(void);
//�豸�Ƿ��Ѵ�
typedef long (__stdcall *x_Device_IsOpen)(void);
//���豸
typedef long (__stdcall *x_Device_Open)(void);
//�ر��豸
typedef void (__stdcall *x_Device_Close)(void);
//�������֤ͼƬ
typedef long (__stdcall *x_Get_IdcPic)(int iCardType, char* szFioutObjSizeameIn);
//��������֤��ͼƬ
typedef long (__stdcall *x_Get_MiscPic)(int iCardType, char* szFioutObjSizeameIn);
//�������֤��Ϣ
typedef long (__stdcall *x_Get_IdcData)(int iCardType, char* szFioutObjSizeameIn, char *szFullFioutObjSizeameOut, char *szHeadFioutObjSizeameOut, struct ID_CARD_S* pstOut);
//��������֤����Ϣ
typedef long (__stdcall *x_Get_MiscData)(int iCardType, char* szFioutObjSizeameIn, char* szFullFioutObjSizeameOut, char* szHeadFioutObjSizeameOut, struct JL_ITEM* pstOut);
//��������֤
typedef long (__stdcall *x_Get_TermbData)(char *szFioutObjSizeameIn, struct TERMB_ITEM* pstOut);
//��ʾ���ô���
typedef long (__stdcall *x_Show_ConfigWindow)(HANDLE *handle, int iCardType);
//��ʾ������Ϣ
typedef long (__stdcall *x_Format_ErrMsg)(int iErrCodeIn, char** pErrMsgOut);
//Bmpת����Jpg
typedef long (__stdcall *x_BmpToJpg)(char* szFioutObjSizeameSrc, char* szFioutObjSizeameDest);
typedef long (__stdcall *x_BmpToJpg2)(char* szFioutObjSizeameSrc, char* szFioutObjSizeameDest, int iWidth, int iHeight);
//�Ĳ�ɫ֤����
typedef long (__stdcall *x_Get_ColorPic)(int iCardType, char *szFullFioutObjSizeameOut, char *szHeadFioutObjSizeameOut);	

struct JL_ITEM jl_item;
struct ID_CARD_S id_card_s;
struct TERMB_ITEM termb_item;

x_Device_IsCanReadTwoCard f_Device_IsCanReadTwoCard;
x_Device_IsOpen f_Device_IsOpen;
x_Device_Open f_Device_Open;
x_Device_Close f_Device_Close;
x_Get_IdcPic f_Get_IdcPic;
x_Get_MiscPic f_Get_MiscPic;
x_Get_IdcData f_Get_IdcData;
x_Get_MiscData f_Get_MiscData;
x_Get_TermbData f_Get_TermbData;
x_Show_ConfigWindow f_Show_ConfigWindow;
x_Format_ErrMsg f_Format_ErrMsg;
x_BmpToJpg f_BmpToJpg;
x_BmpToJpg2 f_BmpToJpg2;
x_Get_ColorPic f_Get_ColorPic;

HMODULE g_hIDRDllModule;

jstring NewJString( JNIEnv * env, LPCTSTR str )
{
	int slen = 0;
	jchar * buffer = NULL;
	int len = 0;
    jstring js = NULL;

    if (!env || !str)
      return 0;
    slen = strlen(str);
    buffer = new jchar[slen];
    len = MultiByteToWideChar(CP_ACP, 0, str, strlen(str), buffer, slen);
    if (len > 0 && len < slen)
      buffer[len] = 0;
    js = env->NewString(buffer, len);
    delete [] buffer;
    return js;
}

JNIEXPORT jint JNICALL Java_JavaCall_Open(JNIEnv *env, jclass object)
{
	int iResult = 0;

	//װ��DLL
	g_hIDRDllModule = LoadLibrary("E:\\JNI\\Dll\\IDRCore.dll");
	if(NULL == g_hIDRDllModule)
	{
		return -1;
	}
		
	//ӳ�亯����ַ
	f_Device_IsCanReadTwoCard = (x_Device_IsCanReadTwoCard)GetProcAddress(g_hIDRDllModule, "Device_IsCanReadTwoCard");
	f_Device_IsOpen = (x_Device_IsOpen)GetProcAddress(g_hIDRDllModule, "Device_IsOpen");
	f_Device_Open = (x_Device_Open)GetProcAddress(g_hIDRDllModule, "Device_Open");
	f_Device_Close = (x_Device_Close)GetProcAddress(g_hIDRDllModule, "Device_Close");
	f_Get_IdcPic = (x_Get_IdcPic)GetProcAddress(g_hIDRDllModule, "Get_IdcPic");
	f_Get_MiscPic = (x_Get_MiscPic)GetProcAddress(g_hIDRDllModule, "Get_MiscPic");
	f_Get_IdcData = (x_Get_IdcData)GetProcAddress(g_hIDRDllModule, "Get_IdcData");
	f_Get_MiscData = (x_Get_MiscData)GetProcAddress(g_hIDRDllModule, "Get_MiscData");
	f_Get_TermbData = (x_Get_TermbData)GetProcAddress(g_hIDRDllModule, "Get_TermbData");
	f_Show_ConfigWindow = (x_Show_ConfigWindow)GetProcAddress(g_hIDRDllModule, "Show_ConfigWindow");
	f_Format_ErrMsg = (x_Format_ErrMsg)GetProcAddress(g_hIDRDllModule, "Format_ErrMsg");
	f_BmpToJpg = (x_BmpToJpg)GetProcAddress(g_hIDRDllModule, "BmpToJpg");
	f_BmpToJpg2 = (x_BmpToJpg2)GetProcAddress(g_hIDRDllModule, "BmpToJpg2");
	f_Get_ColorPic = (x_Get_ColorPic)GetProcAddress(g_hIDRDllModule, "Get_ColorPic");
	
	//���豸
	iResult = f_Device_Open();
	printf("[DLL OUT] f_Device_Open=%d\n", iResult);
	
	return iResult;
}

JNIEXPORT void JNICALL Java_JavaCall_Close(JNIEnv *env, jclass object)
{
	//�ر��豸
	f_Device_Close();
	
	//�ͷ�DLL
	FreeLibrary(g_hIDRDllModule);
	g_hIDRDllModule = NULL;	
}

JNIEXPORT jobjectArray JNICALL Java_JavaCall_test(JNIEnv *env, jclass object, jint invalue)
{
    int i = 0;
	int iResult = 0;
	int iCardType = invalue;//�������
	
    jstring tmpStr;

    jsize outObjSize = 20;//���������С
    jobjectArray outObjs = 0;//��������
	
	outObjs = env->NewObjectArray(outObjSize, env->FindClass("java/lang/String"), NULL);
	
	memset(&id_card_s, 0x00, sizeof(id_card_s));
	memset(&jl_item, 0x00, sizeof(jl_item));
	memset(&termb_item, 0x00, sizeof(termb_item));
	
	printf("[DLL OUT] iCardType=%d\n", iCardType);

	if(1 == iCardType)
	{
		//////////////////////////////һ��֤//////////////////////////////
		//�ɼ�ͼ��
		//	iResult = f_Get_IdcPic(1, "E:\\JNI\\1.bmp");
		//	printf("[DLL OUT] f_Get_IdcPic=%d\n", iResult);
		
		//OCRʶ��
		iResult = f_Get_IdcData(1, "E:\\JNI\\1.bmp", "", "", &id_card_s);
		printf("[DLL OUT] f_Get_IdcData=%d\n", iResult);

		for(i=0; i<outObjSize; i++)
		{
    		printf("[DLL OUT] id_card_s.szText[%d]=%s\n", i, id_card_s.szText[i]);
			tmpStr = NewJString(env, id_card_s.szText[i]);
			env->SetObjectArrayElement(outObjs, i, tmpStr);
		}
	}
	else if(2 == iCardType)
	{
		//////////////////////////////����֤//////////////////////////////
		//�ɼ�ͼ��
		//	iResult = f_Get_IdcPic(2, "E:\\JNI\\2.bmp");
		//	printf("[DLL OUT] f_Get_IdcPic=%d\n", iResult);
		
		//OCRʶ��
		iResult = f_Get_IdcData(2, "E:\\JNI\\2.bmp", "", "", &id_card_s);
		printf("[DLL OUT] f_Get_IdcData=%d\n", iResult);
		
		for(i=0; i<outObjSize; i++)
		{
    		printf("[DLL OUT] id_card_s.szText[%d]=%s\n", i, id_card_s.szText[i]);
			tmpStr = NewJString(env, id_card_s.szText[i]);
			env->SetObjectArrayElement(outObjs, i, tmpStr);
		}
	}

    return outObjs;
} 
