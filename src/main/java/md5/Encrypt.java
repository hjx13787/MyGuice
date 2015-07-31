package md5;

import java.util.Date;

/**
 * 加密
 * @author Michael
 *
 */
public class Encrypt {
	private static String StringXor(String Str, String Key)
	{
	    int vKeyLen = Key.length();
	    char[] StrChars = Str.toCharArray();
	    char[] KeyChars = Key.toCharArray();
	    //int j = 0;
	    for (int i = 0; i < Str.length(); i++){
	    	for(int j = 0; j < Key.length(); j++){
	    		StrChars[i] ^= KeyChars[j++ % Key.length()];
	    		StrChars[i] ^=(j+i)^j^i;
	    	}
	        
	    	//StrChars[i] ^= KeyChars[j++ % Key.length()];
	    }
	    return new String(StrChars);
	}

//	private void button1_Click(Object sender, EventArgs e)
//	{
//	    Text = StringXor(StringXor("Zswang 路过", "密钥"), "密钥");
//	}
	public static void main(String[] args) {
		String m=StringXor("你是一只小小鸟", "huang");
		System.out.println(m);
		//System.out.println(StringXor(m, "huang"));

	}
	
}
