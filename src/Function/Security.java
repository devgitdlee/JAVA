package Function;

import java.security.Key;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;



public class Security {
	 private static String key() {
		  return "abcd1234power_on";
	 }

	public static String Encryption(String Pass) throws Exception {
	  /*
	   * ������ ���Ű�� ������ ���� �޼��� (DES) require Key Size : 16 bytes
	   * @return Key ���Ű Ŭ����
	   * @exception Exception
	  */
	  DESKeySpec desKeySpec = new DESKeySpec(Pass.getBytes());
	  SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	  Key key = keyFactory.generateSecret(desKeySpec);
	  Pass = key.toString();

	  return Pass;
		
	}
	
	/**
	  * ���ڿ� ��Ī ��ȣȭ
	  * @param codedID ���Ű ��ȣȭ�� ����ϴ� ���ڿ�
	  * @return String ��ȣȭ�� ID
	  * @exception Exception
	  */
	/*
	 public static String decrypt(String codedID) throws Exception {
	  if (codedID == null || codedID.length() == 0)
	   return "";
	  // ^��ȣ�� +�� ġȯ�Ѵ�.
	  //  codedID = codedID.replaceAll("_", "+");

	  String instance = (key().length() == 16) ? "DESede/ECB/PKCS5Padding" : "DES/ECB/PKCS5Padding";
	  javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(instance);
	  cipher.init(javax.crypto.Cipher.DECRYPT_MODE, getKey());

	  byte[] inputBytes1 = Base64.decodeBase64(codedID);
	  byte[] outputBytes2 = cipher.doFinal(inputBytes1);

	  String strResult = new String(outputBytes2, "UTF8");
	  return strResult;
	 }
	*/
}
