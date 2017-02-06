package test;

public class StringSplit {

	public StringSplit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String url="http://15.107.14.30:8088/catalog-client/uploads/com.hp.esms.ios.postpay.apk";
		String[] separated = url.split("/");
/*		for(int i=0;i<separated.length;i++){
			System.out.println(separated[i]);
		}*/
		if((separated[separated.length-1]).matches("(.*.apk)|(.*.ipa)|(.*.xap)|(.*.appx)|(.*.appxbundle)")){
		String packageid=separated[separated.length-1].replaceAll("(.apk)|(.ipa)|(.xap)|(.appx)|(.appxbundle)", "");
		System.out.println(packageid);
		}
		
/*		String testa="winterandsommer.ipa";
		if(testa.matches("(.*.apk)|(.*.ipa)")){
			System.out.println("yes");
		}*/
		
	}
}
