package com.hytf.sms;

import java.util.List;

import com.hytf.sms.third.AtyNet;
import com.hytf.sms.third.ModelNode;
import com.hytf.sms.third.ReqMsg;

/**
 * Hello world!
 *
 */
public class App {

	private static final String APPKEY = "c45db841fcf37e48e379e0123193cbf6";

    public static void main( String[] args ) {

    	ReqMsg<List<ModelNode>> reqmsg = AtyNet.getModel(APPKEY);

    	
    	
    	//ReqMsg<List<String>> reqmsg = AtyNet.getBlackWord(APPKEY, "【云返旅游】你购买的机票已成功，请及时查收");
    	//ReqMsg<List<ModelNode>> reqmsg = AtyNet.getModel(APPKEY);
    	//ReqMsg<SmsInfoNode> reqmsg = AtyNet.singleSendSms(APPKEY, "13255984019","【test】测试fe157598");
//    	ReqMsg<ModelNode> reqmsg = AtyNet.getModel(APPKEY,1902444);
//    	List<String> arrMobile = new ArrayList<String>();
//    	arrMobile.add("13255984019");
//    	arrMobile.add("15259125192");
//    	ReqMsg<SmsInfoList> reqmsg = AtyNet.batchSendSms(APPKEY, arrMobile,"【test】测试8547");
//    	ModelNode modelNode = reqmsg.getT();
//    	System.out.println(modelNode);
    	
//    	ReqMsg<ModelNode> reqmsg = AtyNet.delModel(APPKEY, 1902172);	//1902172 1902168 1900972 1900876
//    	
    	
//    	ReqMsg<ModelNode> reqmsg = AtyNet.updModel(APPKEY, 1909034, "【123】213213fee");
    	
    	
    	System.out.println("code:"+reqmsg.getCode());
    	System.out.println("code:"+reqmsg.getDesc());
    	System.out.println("code:"+reqmsg.getT());

    }
}
