package LaVideo;


import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.internal.ole.win32.TYPEATTR;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.OleFunctionDescription;
import org.eclipse.swt.ole.win32.OlePropertyDescription;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
public class LaVideoCtrl {
	
	static OleAutomation oleAutomation;
	static OleControlSite oleControl;
	static OleFrame oleFrame ;
	
	public  void SetFrameSize(int w,int h)
	{
		oleFrame.setSize(w,h);
	}
	public  void SetClientSize(int w,int h)
	{
		oleControl.setSize(w,h);
	}
	
	public int InitOcx(Composite  parent)
	{
	     oleFrame = new OleFrame(parent, SWT.NONE);
	     oleControl = new OleControlSite(oleFrame, SWT.NONE, "VIDEODLL.VideoDllCtrl.1");
		//OleAutomation类用来执行ActiveX中的方法
		 oleAutomation = new OleAutomation(oleControl);
		 oleControl.doVerb(OLE.OLEIVERB_SHOW);
	    return 0;
	}

	public void BuildVideo()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "BuildVideo" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);
	}
	
	public  void StartPreview()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "StartPreview" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);
	}

	public  void StopPreview()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "StopPreview" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	
	}
	
	public  void VideoFit()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "VideoFit" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	
	}
	
	public  void VideoFill()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "VideoFill" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	
	}
	
	public  short GetResolutionCount()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetColorSpaceOutputsizeNum" });
		int dispIdMember = regspid[0];			
		//方法调用
		Variant result=oleAutomation.invoke(dispIdMember);	
		return (short) result.getInt();
	}
	
	public  int GetMediaWidth()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetMediaWidth" });
		int dispIdMember = regspid[0];	
		Variant result=oleAutomation.invoke(dispIdMember);	
		return  result.getInt();
	}
	public  int GetMediaHeight()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetMediaHeight" });
		int dispIdMember = regspid[0];	
		Variant result=oleAutomation.invoke(dispIdMember);	
		return  result.getInt();
	}
	
	public  int GetResolutionWidth(int index)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetOutPutSizeWidth" });
		int dispIdMember = regspid[0];
		//设置方法的具体参数。Variant数组的长度为Method Name方法参数的个数
		//假设有四个参数
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(index);		
		//方法调用
		Variant result=oleAutomation.invoke(dispIdMember, rgvarg);	
		return result.getInt();
	}
	
	
	public  int GetResolutionHeight(int index)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetOutPutSizeHeight" });
		int dispIdMember = regspid[0];
		Variant[] rgvarg = new Variant[1];		
		rgvarg[0] = new Variant(index);
		//方法调用
		Variant result=oleAutomation.invoke(dispIdMember, rgvarg);	
		return result.getInt();
	}
	
	public  void ZoomIn()
	{

		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "ZoomIn" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	
		
		

	}
	
	public  void ZoomOut()
	
	{

		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "ZoomOut" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	

	}
	
	public void PDF_Init(String filepath)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "PDF_Init" });
		int dispIdMember = regspid[0];
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(filepath);
		//方法调用
		oleAutomation.invoke(dispIdMember, rgvarg);	
	}
	
	public void PDF_Add(String filepath)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "PDF_Add" });
		int dispIdMember = regspid[0];
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(filepath);
		//方法调用
		oleAutomation.invoke(dispIdMember, rgvarg);	
	}
	
	public void PDF_Save(String filepath)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "PDF_Save" });
		int dispIdMember = regspid[0];
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(filepath);
		//方法调用
		oleAutomation.invoke(dispIdMember, rgvarg);	
	}
	
	public void ShowVideoFormat()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "ShowVideoPinPropertyPage" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	
	}
	
	
	public void Fit()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "VideoFit" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	
	}
	
	public void Fill()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "VideoFill" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	
	}
	
	public void EnableAuto_Range(int bAuto_Range)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "EnableAuto_Range" });
		int dispIdMember = regspid[0];
		//设置方法的具体参数。Variant数组的长度为Method Name方法参数的个数
		//假设有四个参数
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(bAuto_Range);
		//方法调用
        oleAutomation.invoke(dispIdMember, rgvarg);		
	}
	
	public void SetJpgQuality(int quantity)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "SetJpgQuality" });
		int dispIdMember = regspid[0];
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(quantity);
		oleAutomation.invoke(dispIdMember, rgvarg);

	}
	
	
	public void SetPicDpi(int dpiValue)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "SetPicDpi" });
		int dispIdMember = regspid[0];
			Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(dpiValue);
		oleAutomation.invoke(dispIdMember, rgvarg);

	}
	
	public  void Scan(String Path)
	{
		//System.out.print("22222");
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "TakePicture" });
		int dispIdMember = regspid[0];
		//设置方法的具体参数。Variant数组的长度为Method Name方法参数的个数
		//假设有四个参数
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(Path);
		//方法调用		
		oleAutomation.invoke(dispIdMember, rgvarg);	
	}
	
	public void AddOCRList(String imgPath, String outFilePath)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "AddOCRList" });
		int dispIdMember = regspid[0];
		Variant[] rgvarg = new Variant[2];
		rgvarg[0] = new Variant(imgPath);
		rgvarg[1] = new Variant(outFilePath);		
		
		oleAutomation.invoke(dispIdMember, rgvarg);	
	}
	
	public int CheckDeiceExist()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetDeviceNum" });
		int dispIdMember = regspid[0];
		Variant result=oleAutomation.invoke(dispIdMember);	
		return  result.getInt();
	}
	
	public  void RotateLeft()
	{

		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "RotateLeft" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	

	}
	
	public  void RotateRight()
	{

		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "RotateRight" });
		int dispIdMember = regspid[0];
		oleAutomation.invoke(dispIdMember);	

	}
	
	public void ReSetUpDevice(int index)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "ReSetUpDevice" });
		int dispIdMember = regspid[0];
		//设置方法的具体参数。Variant数组的长度为Method Name方法参数的个数
		//假设有四个参数
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(index);
		
		oleAutomation.invoke(dispIdMember, rgvarg);
	}
	
	public void SetTakeColorMode(int color, int deep)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "SetTakeColorMode" });
		int dispIdMember = regspid[0];
		Variant[] rgvarg = new Variant[2];
		rgvarg[0] = new Variant(color);
		rgvarg[1] = new Variant(deep);
		
		oleAutomation.invoke(dispIdMember, rgvarg);
		
	}
	
	
	public void SetBarCode(int index)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "SetBarCode" });
		int dispIdMember = regspid[0];
		
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(index);
		
		oleAutomation.invoke(dispIdMember, rgvarg);
	}
	
	public int GetBarCodeNum()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetBarCodeNum" });
		int dispIdMember = regspid[0];
		
		Variant result = oleAutomation.invoke(dispIdMember);
		return result.getInt();
	}

	
	public String GetBarCodeTypeStringAt(int index)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetBarCodeTypeStringAt" });
		int dispIdMember = regspid[0];
		
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(index);
		
		Variant result = oleAutomation.invoke(dispIdMember,rgvarg);
		return result.getString();
	}
	
	
	public String GetBarCodeStringAt(int index)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "GetBarCodeStringAt" });
		int dispIdMember = regspid[0];
		
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(index);
		
		Variant result = oleAutomation.invoke(dispIdMember,rgvarg);
		return result.getString();
	}
	
	public void StartRecord(String filePath)
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "StartRecord" });
		int dispIdMember = regspid[0];
		
		Variant[] rgvarg = new Variant[1];
		rgvarg[0] = new Variant(filePath);
		
		oleAutomation.invoke(dispIdMember,rgvarg);
	}
	
	public void StopRecord()
	{
		int[] regspid = oleAutomation.getIDsOfNames(new String[] { "StopRecord" });
		int dispIdMember = regspid[0];
		
		oleAutomation.invoke(dispIdMember);
	}
}
